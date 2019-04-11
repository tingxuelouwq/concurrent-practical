package com.kevin.chap4;

import com.kevin.annotation.Immutable;

/**
 * 类名: Point<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/21 16:41<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@Immutable
public class Point {

    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
