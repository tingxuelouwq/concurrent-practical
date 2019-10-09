package com.kevin.chap5;

import com.kevin.annotation.ThreadSafe;

import java.util.Vector;

/**
 * 类名: SafeVectorHelpers<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/9 14:57<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@ThreadSafe
public class SafeVectorHelpers {
    public static Object getLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }
    }

    public static void deleteLast(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }
}
