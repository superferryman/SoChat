package com.mychat.server;

import com.mychat.common.TCPConstants;
import com.mychat.server.socket.ClientHandler;
import com.mychat.server.socket.Receiver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerService {
    public static ServerSocket serverSocket = null;

    public static List<Socket> clientSocket = null;

    private static ClientHandler clientHandler;

    public static void init() {
        clientSocket = new ArrayList<Socket>();
        startServer();
    }

    public static void startServer() {
        clientHandler = new ClientHandler(TCPConstants.PORT_SERVER);
        new Thread(clientHandler).start();;
    }

    public static void startServer(int port) {
        clientHandler = new ClientHandler(port);
        new Thread(clientHandler).start();
    }

    public static void stopServer() {
        clientHandler.stop();
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void connected(Socket socket) {
        clientSocket.add(socket);
        // TODO 新线程监听连接
        new Thread(new Receiver(socket)).start();
    }
}
