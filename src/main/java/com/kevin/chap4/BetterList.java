package com.kevin.chap4;

import com.kevin.annotation.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名: BetterList<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/4/11 17:12<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@ThreadSafe
public class BetterList<E> extends ArrayList<E> {
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
