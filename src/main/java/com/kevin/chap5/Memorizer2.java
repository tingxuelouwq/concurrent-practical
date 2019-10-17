package com.kevin.chap5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类名: Memorizer2<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/17 11:01<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Memorizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memorizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
