package com.kevin.chap6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类名: ThreadPerTaskWebServer<br/>
 * 包名：com.kevin.chap6<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/31 9:22<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class ThreadPerTaskWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start();
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
