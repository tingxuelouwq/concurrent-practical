package com.kevin.chap3;

/**
 * 类名: ThisSafeTest<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/14 15:09<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class ThisSafeTest {
    public static void main(String[] args) {
        EventSource<EventListener> source = new EventSource<>();
        ListenerRunnable runnable = new ListenerRunnable(source);
        Thread thread = new Thread(runnable);
        thread.start();
        ThisSafe.getInstance(source);
    }
}
