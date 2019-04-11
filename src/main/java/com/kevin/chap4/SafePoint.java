package com.kevin.chap4;

import com.kevin.annotation.GuardedBy;
import com.kevin.annotation.ThreadSafe;

/**
 * 类名: SafePoint<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/4/11 15:21<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
