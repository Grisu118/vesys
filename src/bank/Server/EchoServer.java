package bank.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by benjamin on 20.02.2015.
 */
public class EchoServer {
    public static void main(String args[]) throws IOException {
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Started...");
            while (true) {
                Socket s = server.accept();
                Thread t = new Thread(new EchoHandler(s));
                t.start();
            }
        }
    }

    static class EchoHandler implements Runnable {
        private Socket s;

        EchoHandler(Socket s) {
            this.s = s;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                String input = in.readLine();

                while (input != null && !"".equals(input)) {
                    System.out.println("Input: " + input);
                    out.println(input);
                    input = in.readLine();
                }
                System.out.println("done serving " + s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
