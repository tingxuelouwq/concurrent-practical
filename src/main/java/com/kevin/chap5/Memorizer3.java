package com.kevin.chap5;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 类名: Memorizer3<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/17 17:11<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Memorizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public Memorizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw Preloader.LaunderThrowable.launderThrowable(e);
        }
    }
}
