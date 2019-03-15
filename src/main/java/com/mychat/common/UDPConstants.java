package com.mychat.common;

public class UDPConstants {
    // 公用头部
    public static byte[] HEADER = new byte[] {7, 7, 7, 7, 7, 7, 7, 7};
    // 服务器开放的UDP接收端口
    public static int PORT_SERVER = 30201;
    // 客户端回送端口
    public static int PORT_CLIENT_RESPONSE = 30202;
}
