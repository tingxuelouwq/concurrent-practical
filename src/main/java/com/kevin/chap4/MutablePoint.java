package com.kevin.chap4;

import com.kevin.annotation.NotThreadSafe;

/**
 * 类名: MutablePoint<br/>
 * 包名：com.kevin.chap4<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/21 15:36<br/>
 * 版本：1.0<br/>
 * 描述：
 */
@NotThreadSafe
public class MutablePoint {

    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}

