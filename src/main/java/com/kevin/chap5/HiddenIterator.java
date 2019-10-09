package com.kevin.chap5;

import com.kevin.annotation.GuardedBy;
import com.kevin.annotation.NotThreadSafe;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 类名: HiddenIterator<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/9 15:34<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@NotThreadSafe
public class HiddenIterator {

    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }

    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            add(r.nextInt());
        }
        System.out.println("DEBUG: added ten elements to " + set);
    }
}
