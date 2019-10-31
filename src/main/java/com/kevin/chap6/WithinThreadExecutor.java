package com.kevin.chap6;

import java.util.concurrent.Executor;

/**
 * 类名: WithinThreadExecutor<br/>
 * 包名：com.kevin.chap6<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/31 11:02<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class WithinThreadExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }
}
