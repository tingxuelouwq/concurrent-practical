package com.kevin.chap3;

import java.util.List;

/**
 * 类名: ListenerRunnable<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/14 14:35<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class ListenerRunnable implements Runnable {

    private EventSource<EventListener> source;

    public ListenerRunnable(EventSource<EventListener> source) {
        this.source = source;
    }

    @Override
    public void run() {
        List<EventListener> listeners = null;
        try {
            listeners = source.retrieveListener();
            for (EventListener listener : listeners) {
                listener.onEvent(new Event() {
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}