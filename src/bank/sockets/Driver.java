/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.sockets;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Driver implements bank.BankDriver {
	private SocketBank bank = null;

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

	@Override
	public void connect(String[] args) throws IOException {
		bank = new SocketBank(args);
		System.out.println("connected...");
	}

	@Override
	public void disconnect() throws IOException {
        bank.disconnect();
		bank = null;
		System.out.println("disconnected...");
	}

	@Override
	public Bank getBank() {
		return bank;
	}

	static class SocketBank implements bank.Bank {
        private String address;
        private int port;

        private Socket socket;
        private final PrintWriter out;
        private final BufferedReader in;

        public SocketBank(String[] args) throws IOException {
            if (args.length != 2) {
                throw new IllegalArgumentException();
            }
            this.address = args[0];
            this.port = Integer.parseInt(args[1]);
            socket = new Socket(this.address, this.port);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            in = new BufferedReader( new InputStreamReader(socket.getInputStream(), "UTF-8"));
        }

		@Override
		public Set<String> getAccountNumbers() throws IOException {
            out.println(GETACCOUNTNUMBERS); out.flush();
            HashSet<String> set = new HashSet<>();
            String input = in.readLine();
            while (input != null && !"-END-".equals(input)) {
                System.out.println(input);
                set.add(input);
                input = in.readLine();
            }
            return set;
		}

		@Override
		public String createAccount(String owner) throws IOException {
            out.println(CREATEACC);
            out.println(owner);
            out.flush();
            System.out.println("CreateAcc, Flushed");
            String s = in.readLine();
            System.out.println(s);
			return s;
		}

		@Override
		public boolean closeAccount(String number) throws IOException {
            out.println(CLOSEACC);
            out.println(number);
            out.flush();
			return Boolean.parseBoolean(in.readLine());
		}

		@Override
		public bank.Account getAccount(String number) throws IOException {
            out.println(GETACC);
            out.println(number);
            out.flush();

            String owner = in.readLine();
            try {
                Integer.parseInt(owner);
            } catch (NumberFormatException e) {
                String balance = in.readLine();
                String active = in.readLine();
                return new Account(owner, number, Double.parseDouble(balance), Boolean.parseBoolean(active), out, in);
            }
            return null;
		}

		@Override
		public void transfer(bank.Account from, bank.Account to, double amount)
				throws IOException, InactiveException, OverdrawException {
            String f = from.getNumber();
            String t = to.getNumber();

            out.println(TRANSFER);
            out.println(f);
            out.println(t);
            out.println(amount);
            out.flush();

            String input = in.readLine();
            if (!"true".equals(input)) {
                int i = Integer.parseInt(input);
                if (i == INACITVEEX) {
                    throw new InactiveException();
                } else if (i == OVERDRAWEX) {
                    throw new OverdrawException();
                }
            }

		}

        public void disconnect() throws IOException {
            socket.close();
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

        Account(String owner, String number, double balance, boolean active, PrintWriter out, BufferedReader in) {
            this.owner = owner;
            this.number = number;
            this.balance = balance;
            this.active = active;
            this.out = out;
            this.in = in;
        }

		@Override
		public double getBalance() throws IOException {
            updateAcc();
			return balance;
		}

		@Override
		public String getOwner() throws IOException {
            updateAcc();
			return owner;
		}

		@Override
		public String getNumber() throws IOException {
            updateAcc();
			return number;
		}

		@Override
		public boolean isActive() throws IOException {
            updateAcc();
			return active;
		}

        public boolean setInactive() throws IOException {
            updateAcc();
            if (balance == 0 && active) {
                out.println(SETINACITVE);
                out.println(number);
                out.flush();
                active = false;
                return Boolean.parseBoolean(in.readLine());
            }
            return false;
        }

		@Override
		public void deposit(double amount) throws IOException, InactiveException {
            updateAcc();
			if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            balance += Math.abs(amount);
            out.println(DEPOSIT);
            out.println(number);
            out.println(Math.abs(amount));
            out.flush();

            String input = in.readLine();
            if (!"true".equals(input)) {
                int i = Integer.parseInt(input);
                if (i == INACITVEEX) {
                    throw new InactiveException();
                }
            }
		}

		@Override
		public void withdraw(double amount) throws IOException, InactiveException, OverdrawException {
            updateAcc();
            if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            if (balance < Math.abs(amount)) {
                throw new OverdrawException();
            }
            balance -= Math.abs(amount);
            out.println(WITHDRAW);
            out.println(number);
            out.println(Math.abs(amount));
            out.flush();

            String input = in.readLine();
            if (!"true".equals(input)) {
                int i = Integer.parseInt(input);
                if (i == INACITVEEX) {
                    throw new InactiveException();
                } else if (i == OVERDRAWEX) {
                    throw new OverdrawException();
                }
            }
		}

        private void updateAcc() throws IOException {
            out.println(GETACC);
            out.println(number);
            out.flush();

            String owner = in.readLine();
            try {
                Integer.parseInt(owner);
            } catch (NumberFormatException e) {
                this.owner = owner;
                balance = Double.parseDouble(in.readLine());
                active = Boolean.parseBoolean(in.readLine());
            }
        }

	}

}