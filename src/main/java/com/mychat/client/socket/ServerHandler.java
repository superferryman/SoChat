package com.mychat.client.socket;

import com.mychat.client.ClientService;

import java.io.IOException;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private String host;

    private int port;

    public ServerHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ClientService.socket = new Socket(host, port);
            ClientService.receiver = new Receiver();
            new Thread(ClientService.receiver).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {

    }
}
