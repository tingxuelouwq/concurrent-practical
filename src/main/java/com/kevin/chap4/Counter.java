package com.kevin.chap4;

import com.kevin.annotation.GuardedBy;
import com.kevin.annotation.ThreadSafe;

/**
 * 类名: Counter<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/22 10:34<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@ThreadSafe
public class Counter {
    @GuardedBy("this") private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalArgumentException("counter overflow");
        }
        return ++value;
    }
}
