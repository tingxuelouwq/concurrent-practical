package com.kevin.chap5;

import com.kevin.annotation.NotThreadSafe;

import java.util.Vector;

/**
 * 类名: UnsafeVectorHelpers<br/>
 * 包名：com.kevin.chap5<br/>
 * 作者：kevin<br/>
 * 时间：2019/10/9 14:55<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@NotThreadSafe
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
