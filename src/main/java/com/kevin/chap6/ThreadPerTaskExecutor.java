package com.kevin.chap6;

import java.util.concurrent.Executor;

/**
 * 类名: ThreadPerTaskExecutor<br/>
 * 包名：com.kevin.chap6<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/31 10:58<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class ThreadPerTaskExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
