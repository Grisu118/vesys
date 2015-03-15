package bank.Server;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;

import java.io.IOException;
import java.util.*;

/**
 * Created by benjamin on 15.03.2015.
 */
public class ServerBank implements Bank {

    private final Map<String, Account> accounts = new HashMap<>();
    private int num = 0;


    @Override
    public Set<String> getAccountNumbers() throws IOException {
        Iterator<Account> it = accounts.values().iterator();
        HashSet<String> set = new HashSet<>();
        while (it.hasNext()) {
            String s = it.next().getNumber();
            if (accounts.get(s).isActive()) {
                set.add(s);
            }
        }
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
        Account a = new ServerAccount(owner, accnum.toString().toUpperCase());
        accounts.put(a.getNumber(), a);
        return a.getNumber();
    }

    @Override
    public boolean closeAccount(String number) throws IOException {
        return accounts.get(number).setInactive();
    }

    @Override
    public Account getAccount(String number) throws IOException {
        return accounts.get(number);
    }

    @Override
    public void transfer(bank.Account from, bank.Account to, double amount)
            throws IOException, InactiveException, OverdrawException {
        from.withdraw(amount);
        to.deposit(amount);
    }
}






