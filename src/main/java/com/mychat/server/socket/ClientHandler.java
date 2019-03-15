package com.mychat.server.socket;

import com.mychat.common.TCPConstants;
import com.mychat.server.ServerService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private boolean running;

    private Integer port = null;

    public ClientHandler() { }

    public ClientHandler(Integer port) {
        this.port = port;
    }

    @Override
    public void run() {
        this.running = true;

        try {
            if (port == null) {
                port = TCPConstants.PORT_SERVER;
            }
            ServerService.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (running && ServerService.serverSocket != null) {
                Socket socket = ServerService.serverSocket.accept();
                System.out.println("已连接....");
                ServerService.connected(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.running = false;
    }
}
