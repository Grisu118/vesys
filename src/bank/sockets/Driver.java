/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.sockets;

import bank.InactiveException;
import bank.OverdrawException;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Driver implements bank.BankDriver {
	private Bank bank = null;

	@Override
	public void connect(String[] args) throws IOException {
		bank = new Bank(args);
		System.out.println("connected...");
	}

	@Override
	public void disconnect() throws IOException {
		bank = null;
		System.out.println("disconnected...");
	}

	@Override
	public Bank getBank() {
		return bank;
	}

	static class Bank implements bank.Bank {
        private String address;
        private int port;

        private Socket socket;

        public Bank(String[] args) throws IOException {
            if (args.length != 2) {
                throw new IllegalArgumentException();
            }
            this.address = args[0];
            this.port = Integer.parseInt(args[1]);
            socket = new Socket(this.address, this.port);
        }

		private final Map<String, Account> accounts = new HashMap<>();
        private int num = 0;

		@Override
		public Set<String> getAccountNumbers() {
            return accounts.values().stream().filter(a -> a.isActive()).map(a -> a.getNumber()).collect(Collectors.toSet());
		}

		@Override
		public String createAccount(String owner) {
            String[] names = owner.split(" ");
            StringBuilder accnum = new StringBuilder();
            if (names.length > 1) {
                accnum.append(names[0].charAt(0));
                accnum.append(names[1].charAt(0));
            } else if(owner.length() > 1) {
                accnum.append(owner.substring(0, 2));
            } else {
                accnum.append(owner);
            }
            accnum.append('-');
            String s = String.format("%06d", ++num);
            accnum.append(s.substring(0, 4)).append("-").append(s.substring(4, 6));
			Account a = new Account(owner, accnum.toString().toUpperCase());
            accounts.put(a.getNumber(), a);
			return a.getNumber();
		}

		@Override
		public boolean closeAccount(String number) {
			return accounts.get(number).setInactive();
		}

		@Override
		public bank.Account getAccount(String number) {
			return accounts.get(number);
		}

		@Override
		public void transfer(bank.Account from, bank.Account to, double amount)
				throws IOException, InactiveException, OverdrawException {
			from.withdraw(amount);
            to.deposit(amount);
		}

	}

	static class Account implements bank.Account {
		private String number;
		private String owner;
		private double balance;
		private boolean active = true;

		Account(String owner, String number) {
			this.owner = owner;
			this.number = number;
		}

		@Override
		public double getBalance() {
			return balance;
		}

		@Override
		public String getOwner() {
			return owner;
		}

		@Override
		public String getNumber() {
			return number;
		}

		@Override
		public boolean isActive() {
			return active;
		}

        public boolean setInactive() {
            if (balance == 0 && active) {
                active = false;
                return true;
            }
            return false;
        }

		@Override
		public void deposit(double amount) throws InactiveException {
			if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            balance += Math.abs(amount);
		}

		@Override
		public void withdraw(double amount) throws InactiveException, OverdrawException {
            if (!active) {
                throw new InactiveException(number + " is Inactive!");
            }
            if (balance < Math.abs(amount)) {
                throw new OverdrawException();
            }
            balance -= Math.abs(amount);
		}

	}

}