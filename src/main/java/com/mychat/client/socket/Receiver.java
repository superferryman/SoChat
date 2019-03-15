package com.mychat.client.socket;

import com.mychat.client.ClientService;

import java.io.*;

public class Receiver implements Runnable {
    private boolean running;

    @Override
    public void run() {
        running = true;
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader
                    (ClientService.socket.getInputStream()));

            while (running && ClientService.socket != null) {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                new Thread(new Sender(input.readLine())).start();

                String message = buf.readLine();
                if (message == null || "".equals(message)) {
                    running = false;
                } else {
                    if ("00bye00".equals(message)) {
                        running = false;
                    } else {
                        // TODO: 使用工具类将信息抽取
                        System.out.println("来自服务器的信息: " + message);
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
