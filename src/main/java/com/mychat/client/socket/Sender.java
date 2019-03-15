package com.mychat.client.socket;

import com.mychat.client.ClientService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class Sender implements Runnable {
    private String message;

    public Sender(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        if (ClientService.socket != null) {
            BufferedWriter buf = null;
            try {
                PrintStream out = new PrintStream(ClientService.socket.getOutputStream());
                out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
