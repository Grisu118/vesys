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

    public static final int GETACCOUNTNUMBERS = 10;
    public static final int CREATEACC = 20;
    public static final int CLOSEACC = 30;
    public static final int GETACC = 40;
    public static final int TRANSFER = 50;
    public static final int SETINACITVE = 100;
    public static final int DEPOSIT = 110;
    public static final int WITHDRAW = 120;
    public static final int INACITVEEX = 500;
    public static final int OVERDRAWEX = 510;
    public static final int NULLPTR = 520;

    static class BankHandler implements Bank, Runnable {
        private Socket socket;
        private final PrintWriter out;
        private final BufferedReader in;

        private final Map<String, Account> accounts = new HashMap<>();
        private int num = 0;

        public BankHandler(Socket s) throws IOException {
            socket = s;
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        }

        public void run() {
            try {
                String input = in.readLine();

                while (input != null) {
                    System.out.println("Input: " + input);
                    switch (Integer.parseInt(input)) {
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
                                out.println(true);
                                out.flush();
                            } catch (InactiveException e) {
                                out.println(INACITVEEX);
                                out.flush();
                                e.printStackTrace();
                            } catch (OverdrawException e) {
                                out.println(OVERDRAWEX);
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
                                out.println(true);
                                out.flush();
                            } catch (InactiveException e) {
                                out.println(INACITVEEX);
                                out.flush();
                                e.printStackTrace();
                            }
                            break;
                        case WITHDRAW:
                            try {
                                getAccount(in.readLine()).withdraw(Double.parseDouble(in.readLine()));
                                out.println(true);
                                out.flush();
                            } catch (InactiveException e) {
                                out.println(INACITVEEX);
                                out.flush();
                                e.printStackTrace();
                            } catch (OverdrawException e) {
                                out.println(OVERDRAWEX);
                                out.flush();
                                e.printStackTrace();
                            }
                            break;
                        default:
                            out.println("Error");
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
                    System.err.println(e);
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
                    out.println(s);
                    set.add(s);
                }
            }
            out.println("-END-");
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
            Account a = new Account(owner, accnum.toString().toUpperCase(), out, in);
            accounts.put(a.getNumber(), a);
            System.out.println("Account Created: " + a.getNumber());
            out.println(a.getNumber());
            out.flush();
            return a.getNumber();
        }

        @Override
        public boolean closeAccount(String number) throws IOException {
            return accounts.get(number).setInactive();
        }

        public void silentGetAccount(String number) throws IOException {
            Account a = accounts.get(number);
            if (a == null) {
                out.println(NULLPTR);
                out.flush();
            } else {
                out.println(a.getOwner());
                out.println(a.getBalance());
                out.println(a.isActive());
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

        private final PrintWriter out;
        private final BufferedReader in;

        Account(String owner, String number, PrintWriter out, BufferedReader in) {
            this.owner = owner;
            this.number = number;
            this.out = out;
            this.in = in;
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
                out.println(true);
                out.flush();
                return true;
            }
            out.println(false);
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