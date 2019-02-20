package com.kevin.chap2;

/**
 * 类名: Derive<br/>
 * 包名：com.kevin<br/>
 * 作者：kevin<br/>
 * 时间：2019/2/19 16:55<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class Derive extends Base {
    @Override
    public void doSomething() {
        super.doSomething();
        System.out.println("Derive.this: " + this);
    }

    /**
     * super.doSomething()的含义是，通过super引用调用从父类继承而来的doSomething()方法，那么锁的
     * 还是当前的子类对象，因此子类对象被锁了2次，说明内置锁是可重入的，否则会发生死锁。
     */
    public static void main(String[] args) {
        Derive derive = new Derive();
        derive.doSomething();
    }
}
