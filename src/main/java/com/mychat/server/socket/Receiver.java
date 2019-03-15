package com.mychat.server.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Receiver implements Runnable {
    private boolean running;

    private Socket clientSocket;

    public Receiver(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        running = true;

        try {
            PrintStream out = new PrintStream(clientSocket.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader
                    (clientSocket.getInputStream()));

            while (running && this.clientSocket != null) {
                String message = buf.readLine();
                if (message == null || "".equals(message)) {
                    running = false;
                } else {
                    if ("00bye00".equals(message)) {
                        running = false;
                    } else {
                        System.out.println("来自客户端的信息: " + message);
                        out.println(message);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        running = false;
    }
}
