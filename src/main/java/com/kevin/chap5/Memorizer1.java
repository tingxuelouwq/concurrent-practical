package com.kevin.chap5;

import com.kevin.annotation.GuardedBy;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 类名: Memoizer1<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/17 10:52<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class Memorizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();

    private final Computable<A, V> c;

    public Memorizer1(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) {
        // after deep thought...
        return new BigInteger(arg);
    }
}
