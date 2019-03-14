package com.kevin.chap3;

/**
 * 类名: ThisEscape<br/>
 * 包名：com.kevin.chap3<br/>
 * 作者：kevin<br/>
 * 时间：2019/3/13 11:02<br/>
 * 版本：1.0<br/>
 * 描述：Implicitly allowing the this reference to escape
 */
public class ThisEscape {

    private final int id;
    private final String name;

    public ThisEscape(EventSource<EventListener> source) {
        id = 1;
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                System.out.println("id: " + ThisEscape.this.id);
                System.out.println("name: " + ThisEscape.this.name);
            }
        });
        try {
            Thread.sleep(3000); // 模拟其他耗时的初始化操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "kevin";
    }
}
