package com.mychat.server.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Sender implements Runnable {
    private Socket socket;

    // TODO: 要发送的内容抽象
    private String message;

    public Sender(Socket socket, String message) {
        this.socket = socket;
        this.message = message;
    }

    @Override
    public void run() {
        if (socket != null) {
            try {
                BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                buf.write(message);
                buf.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
