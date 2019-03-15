package com.mychat.client;

import com.mychat.client.socket.Receiver;
import com.mychat.client.socket.Sender;
import com.mychat.client.socket.ServerHandler;
import com.mychat.common.TCPConstants;

import java.net.Socket;

public class ClientService {
    public static Socket socket = null;

    public static Receiver receiver;

    public static void init() {
        new Thread(new ServerHandler("127.0.0.1", TCPConstants.PORT_SERVER)).start();
    }

    public static void sendMessage(String message) {
        new Thread(new Sender(message)).start();
    }
}
