package com.kevin.chap5;

import java.util.concurrent.BlockingQueue;

/**
 * 类名: TaskRunnable<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/14 10:21<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class TaskRunnable implements Runnable {

    private BlockingQueue<Task> queue;

    @Override
    public void run() {
        try {
            processTask(queue.take());
        } catch (InterruptedException e) {
            // restore interrupted status
            Thread.currentThread().interrupt();
        }
    }

    private void processTask(Task task) {
        // Handle the task
    }

    interface Task {}
}
