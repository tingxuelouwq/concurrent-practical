package com.kevin.chap6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 类名: TaskExecutionWebServer<br/>
 * 包名：com.kevin.chap6<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/31 10:24<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class TaskExecutionWebServer {

    private static final int NTHREADS = 100;
    private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            exec.execute(task);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
    }
}
