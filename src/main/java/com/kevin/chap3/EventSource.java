package com.kevin.chap3;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名: EventSource<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/14 14:33<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class EventSource<T> {

    private final List<T> eventListeners;

    public EventSource() {
        this.eventListeners = new ArrayList<>();
    }

    public synchronized void registerListener(T e) {
        eventListeners.add(e);
        this.notifyAll();
    }

    public synchronized List<T> retrieveListener() throws InterruptedException {
        List<T> result = null;
        if (eventListeners.isEmpty()) {
            this.wait();
        }
        result = new ArrayList<>(eventListeners.size());
        result.addAll(eventListeners);
        return result;
    }
}