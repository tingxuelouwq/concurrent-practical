package com.kevin.chap2;

/**
 * 类名: Base<br/>
 * 包名：com.kevin<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/19 16:55<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class Base {

    public void doSomething() {
        synchronized (this) {
            System.out.println("Base.this: " + this);
        }
    }
}
