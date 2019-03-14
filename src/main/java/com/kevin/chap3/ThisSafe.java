package com.kevin.chap3;

/**
 * 类名: ThisSafe<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/14 14:41<br/>
 * 版本：1.0<br/>
 * 描述：
 */
public class ThisSafe {

    private final int id;
    private final String name;
    private final EventListener listener;

    private ThisSafe() {
        id = 1;
        listener = new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.println("id: " + ThisSafe.this.id);
                System.out.println("name: " + ThisSafe.this.name);
            }
        };
        try {
            Thread.sleep(3000); // 模拟其他耗时的初始化操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "kevin";
    }

    public static ThisSafe getInstance(EventSource<EventListener> source) {
        ThisSafe safe = new ThisSafe();
        source.registerListener(safe.listener);
        return safe;
    }
}
