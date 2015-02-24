/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.Server;

import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

@SuppressWarnings("InfiniteLoopStatement")
public class SocketServer {

    public static void main(String args[]) throws IOException {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Started...");
            while (true) {
                Socket s = server.accept();
                Thread t = new Thread(new BankHandler(s));
                t.start();
            }
        }
    }

    public static final String GETACCOUNTNUMBERS = "10";
    public static final String CREATEACC = "20";
    public static final String CLOSEACC = "30";
    public static final String GETACC = "40";
    public static final String TRANSFER = "50";
    public static final String SETINACITVE = "100";
    public static final String DEPOSIT = "110";
    public static final String WITHDRAW = "120";
    public static final String INACITVEEX = "500";
    public static final String OVERDRAWEX = "510";
    public static final String NULLPTR = "520";

    private static final Map<String, Account> accounts = new HashMap<>();
    private static int num = 0;

    static class BankHandler implements Bank, Runnable {
        private Socket socket;
        private final BufferedWriter out;
        private final BufferedReader in;


        public BankHandler(Socket s) throws IOException {
            socket = s;
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        }

        public void run() {
            try {
                String input = in.readLine();

                while (input != null) {
                    System.out.println("Input: " + input);
                    switch (input) {
                        case GETACCOUNTNUMBERS:
                            getAccountNumbers();
                            break;
                        case CREATEACC:
                            createAccount(in.readLine());
                            break;
                        case CLOSEACC:
                            closeAccount(in.readLine());
                            break;
                        case GETACC:
                            silentGetAccount(in.readLine());
                            break;
                        case TRANSFER:
                            try {
                                transfer(getAccount(in.readLine()), getAccount(in.readLine()), Double.parseDouble(in.readLine()));
                                out.write("true");
                                out.newLine();
                                out.flush();
                            } catch (InactiveException e) {
                                out.write(INACITVEEX);
                                out.newLine();
                                out.flush();
                                e.printStackTrace();
                            } catch (OverdrawException e) {
                                out.write(OVERDRAWEX);
                                out.newLine();
                                out.flush();
                                e.printStackTrace();
                            }
                            break;
                        case SETINACITVE:
                            getAccount(in.readLine()).setInactive();
                            break;
                        case DEPOSIT:
                            try {
                                getAccount(in.readLine()).deposit(Double.parseDouble(in.readLine()));
                                out.write("true");
                                out.newLine();
                                out.flush();
                            } catch (InactiveException e) {
                                out.write(INACITVEEX);
                                out.newLine();
                                out.flush();
                                e.printStackTrace();
                            }
                            break;
                        case WITHDRAW:
                            try {
                                getAccount(in.readLine()).withdraw(Double.parseDouble(in.readLine()));
                                out.write("true");
                                out.newLine();
                                out.flush();
                            } catch (InactiveException e) {
                                out.write(INACITVEEX);
                                out.newLine();
                                out.flush();
                                e.printStackTrace();
                            } catch (OverdrawException e) {
                                out.write(OVERDRAWEX);
                                out.newLine();
                                out.flush();
                                e.printStackTrace();
                            }
                            break;
                        default:
                            out.write("Error");
                            out.newLine();
                            out.flush();
                    }
                    input = in.readLine();
                }
                System.out.println("done serving " + socket);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        @Override
        public Set<String> getAccountNumbers() throws IOException {
            System.out.println("getAccountNumbers");
            Iterator<Account> it = accounts.values().iterator();
            HashSet<String> set = new HashSet<>();
            while (it.hasNext()) {
                String s = it.next().getNumber();
                if (accounts.get(s).isActive()) {
                    System.out.println(s);
                    out.write(s);
                    out.newLine();
                    set.add(s);
                }
            }
            out.write("-END-");
            out.newLine();
            System.out.println("-END-");
            out.flush();
            return set;
        }

        @Override
        public String createAccount(String owner) throws IOException {
            String[] names = owner.split(" ");
            StringBuilder accnum = new StringBuilder();
            if (names.length > 1) {
                accnum.append(names[0].charAt(0));
                accnum.append(names[1].charAt(0));
            } else if (owner.length() > 1) {
                accnum.append(owner.substring(0, 2));
            } else {
                accnum.append(owner);
            }
            accnum.append('-');
            String s = String.format("%06d", ++num);
            accnum.append(s.substring(0, 4)).append("-").append(s.substring(4, 6));
            Account a = new Account(owner, accnum.toString().toUpperCase(), out);
            accounts.put(a.getNumber(), a);
            System.out.println("Account Created: " + a.getNumber());
            out.write(a.getNumber());
            out.newLine();
            out.flush();
            return a.getNumber();
        }

        @Override
        public boolean closeAccount(String number) throws IOException {
            return accounts.get(number).setInactive();
        }

        public void silentGetAccount(String number) throws IOException {
            System.out.println("Entered Gett Acc: " + number);
            Account a = accounts.get(number);
            if (a == null) {
                System.out.println("Is null: ");
                out.write(NULLPTR);
                out.newLine();
                out.flush();
            } else {
                out.write(a.getOwner());
                out.newLine();
                out.write(Double.toString(a.getBalance()));
                out.newLine();
                out.write(Boolean.toString(a.isActive()));
                out.newLine();
                out.flush();
            }
        }

        @Override
        public Account getAccount(String number) throws IOException {
            return accounts.get(number);
        }

        @Override
        public void transfer(bank.Account from, bank.Account to, double amount)
                throws IOException, InactiveException, OverdrawException {
            System.out.println("Entered Transfer");
            from.withdraw(amount);
            to.deposit(amount);
            System.out.println("Left Transfer");
        }
    }

    static class Account implements bank.Account {
        private String number;
        private String owner;
        private double balance;
        private boolean active = true;

        private final BufferedWriter out;

        Account(String owner, String number, BufferedWriter out) {
            this.owner = owner;
            this.number = number;
            this.out = out;
        }

        @Override
        public double getBalance() throws IOException {
            return balance;
        }

        @Override
        public String getOwner() throws IOException {
            return owner;
        }

        @Override
        public String getNumber() throws IOException {
            return number;
        }

        @Override
        public boolean isActive() throws IOException {
            return active;
        }

        public boolean setInactive() throws IOException {
            if (balance == 0 && active) {
                active = false;
                out.write("true");
                out.newLine();
                out.flush();
                return true;
            }
            out.write("false");
            out.newLine();
            out.flush();
            return false;
        }

        @Override
        public void deposit(double amount) throws IOException, InactiveException {
            System.out.println("Entered deposit");
            if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            balance += Math.abs(amount);
            System.out.println("Left deposit");
        }

        @Override
        public void withdraw(double amount) throws IOException, InactiveException, OverdrawException {
            System.out.println("Entered withdraw");
            if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            if (balance < Math.abs(amount)) {
                throw new OverdrawException();
            }
            balance -= Math.abs(amount);
            System.out.println("Left withdraw");
        }


    }

}