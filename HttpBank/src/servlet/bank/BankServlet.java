/*
 * Copyright (c) 2000-2015 Fachhochschule Nordwestschweiz (FHNW)
 * All Rights Reserved. 
 */

package servlet.bank;

import bank.Account;
import bank.Bank;
import bank.InactiveException;
import bank.OverdrawException;
import bank.Server.ServerBank;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@WebServlet(
        name="BankServlet",
        urlPatterns={"/req"},
        initParams={
                @WebInitParam(name="simpleParam", value="paramValue")
        }
)
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
    public static final String ILLEGALARG = "530";

    private static final String MESSAGESTART = "{ \"message\": \"";
    private static final String MESSAGEEND = "\"}";
    private static final String SUCCESS = MESSAGESTART + "true" + MESSAGEEND;

    private Bank bank;

    @Override
    public void init() throws ServletException {
        super.init();
        bank = new ServerBank();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String type = request.getParameter("type");

        switch (type) {
            case GETACCOUNTNUMBERS:
                List<String> l = new LinkedList<>();
                l.addAll(bank.getAccountNumbers());
                out.write(new Gson().toJson(l));
                out.flush();
                break;
            case CREATEACC:
                String nr = bank.createAccount(request.getParameter("owner"));
                try {
                    bank.getAccount(nr).deposit(Double.parseDouble(request.getParameter("balance")));
                } catch (InactiveException e) {
                    //Can not happen after first creation
                }
                out.write(MESSAGESTART + nr + MESSAGEEND);

                out.flush();
                break;
            case CLOSEACC:
                out.write(MESSAGESTART + Boolean.toString(bank.closeAccount(request.getParameter("accNumber"))) + MESSAGEEND);
                out.flush();
                break;
            case GETACC: {
                Account a = bank.getAccount(request.getParameter("accNumber"));
                if (a == null) {
                    out.write(MESSAGESTART + NULLPTR + MESSAGEEND);
                    out.flush();
                } else {
                    out.write(new Gson().toJson(a));
                    out.flush();
                }
                break;
            }
            case TRANSFER:
                try {
                    Account from = bank.getAccount(request.getParameter("from"));
                    Account to = bank.getAccount(request.getParameter("to"));
                    if (from != null && to != null) {
                        bank.transfer(from, to, Double.parseDouble(request.getParameter("amount")));
                        out.write(SUCCESS);
                    } else {
                        out.write(MESSAGESTART + NULLPTR + MESSAGEEND);
                    }
                } catch (InactiveException e) {
                    out.write(MESSAGESTART + INACITVEEX + MESSAGEEND);
                } catch (OverdrawException e) {
                    out.write(MESSAGESTART + OVERDRAWEX + MESSAGEEND);
                } catch (IllegalArgumentException e) {
                    out.write(MESSAGESTART + ILLEGALARG + MESSAGEEND);
                }
                out.flush();
                break;
            case DEPOSIT:
                try {
                    Account a = bank.getAccount(request.getParameter("accNumber"));
                    if (a != null) {
                        a.deposit(Double.parseDouble(request.getParameter("amount")));
                        out.write(SUCCESS);
                    } else {
                        out.write(MESSAGESTART + NULLPTR + MESSAGEEND);
                    }
                } catch (InactiveException e) {
                    out.write(MESSAGESTART + INACITVEEX + MESSAGEEND);
                } catch (IllegalArgumentException e) {
                    out.write(MESSAGESTART + ILLEGALARG + MESSAGEEND);
                }
                out.flush();
                break;
            case WITHDRAW:
                try {
                    Account a = bank.getAccount(request.getParameter("accNumber"));
                    if (a != null) {
                        a.withdraw(Double.parseDouble(request.getParameter("amount")));
                        out.write(SUCCESS);
                    } else {
                        out.write(MESSAGESTART + NULLPTR + MESSAGEEND);
                    }
                } catch (InactiveException e) {
                    out.write(MESSAGESTART + INACITVEEX + MESSAGEEND);
                } catch (IllegalArgumentException e) {
                    out.write(MESSAGESTART + ILLEGALARG + MESSAGEEND);
                } catch (OverdrawException e) {
                    out.write(MESSAGESTART + OVERDRAWEX + MESSAGEEND);
                }
                out.flush();
                break;

            default:
                out.write(MESSAGESTART + "Error" + MESSAGEEND);
                out.flush();

        }


    }

}