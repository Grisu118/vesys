package ch.fhnw.ds.rmi.calculator;

import java.util.Date;

public class CalculatorImpl extends java.rmi.server.UnicastRemoteObject implements Calculator {

	public CalculatorImpl() throws java.rmi.RemoteException {
	}

	public CalculatorImpl(int port) throws java.rmi.RemoteException {
		super(port);
	}

	public long add(long a, long b) {
        System.out.println(String.format(">>add %tT [%d] %s", new Date(), System.identityHashCode(this), Thread.currentThread()));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
        }
        System.out.println(String.format("<<add %tT [%d] %s", new Date(), System.identityHashCode(this), Thread.currentThread()));
        return a + b;
	}

	public long sub(long a, long b) {
		return a - b;
	}

	public long mul(long a, long b) {
		return a * b;
	}

	public long div(long a, long b) {
		return a / b;
	}
}
