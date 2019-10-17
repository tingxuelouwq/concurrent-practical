package com.kevin.chap5;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 类名: Memorizer<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/17 18:38<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Memorizer<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memorizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg, f);
            } catch (ExecutionException e) {
                throw Preloader.LaunderThrowable.launderThrowable(e);
            }
        }
    }
}
