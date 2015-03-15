/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package bank.Server;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("InfiniteLoopStatement")
public class BankServlet extends HttpServlet {

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

    Bank bank;

    @Override
    public void init() throws ServletException {
        super.init();
        bank = new ServerBank();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String type = request.getParameter("type");
        /*
        switch (type) {
            case GETACCOUNTNUMBERS:
                for (String s : bank.getAccountNumbers()) {
                    out.write(s);
                    out.newLine();
                }
                out.write("-END-");
                out.newLine();
                out.flush();
                break;
            case CREATEACC:
                out.write(bank.createAccount(in.readLine()));
                out.newLine();
                out.flush();
                break;
            case CLOSEACC:
                out.write(Boolean.toString(bank.closeAccount(in.readLine())));
                out.newLine();
                out.flush();
                break;
            case GETACC:
                Account a = bank.getAccount(in.readLine());
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
                break;
            case TRANSFER:
                try {
                    bank.transfer(bank.getAccount(in.readLine()), bank.getAccount(in.readLine()), Double.parseDouble(in.readLine()));
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
                bank.getAccount(in.readLine()).setInactive();
                break;
            case DEPOSIT:
                try {
                    bank.getAccount(in.readLine()).deposit(Double.parseDouble(in.readLine()));
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
                    bank.getAccount(in.readLine()).withdraw(Double.parseDouble(in.readLine()));
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
        */

    }

}