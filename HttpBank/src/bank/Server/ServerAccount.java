package bank.Server;

import bank.Account;
import bank.InactiveException;
import bank.OverdrawException;

import java.io.IOException;

/**
 * Created by benjamin on 15.03.2015.
 */
public class ServerAccount implements Account {
    private String number;
    private String owner;
    private double balance;
    private boolean active = true;


    ServerAccount(String owner, String number) {
        this.owner = owner;
        this.number = number;
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
            return true;
        }
        return false;
    }

    @Override
    public void deposit(double amount) throws IOException, InactiveException {
        if (!active) {
            throw new InactiveException(number + " is Inactive!");
        }
        balance += Math.abs(amount);
    }

    @Override
    public void withdraw(double amount) throws IOException, InactiveException, OverdrawException {
        if (!active) {
            throw new InactiveException(number + " is Inactive!");
        }
        if (balance < Math.abs(amount)) {
            throw new OverdrawException();
        }
        balance -= Math.abs(amount);
    }
}
