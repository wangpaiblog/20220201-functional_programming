package org.wangpai.demo.fp.blackbox;

import java.util.HashMap;
import lombok.Setter;
import lombok.SneakyThrows;
import org.wangpai.demo.fp.blackbox.event.Event;
import org.wangpai.demo.fp.blackbox.handler.Handler;

@Setter
public class MockServer {
    private Handler onReceiveHandler;

    @SneakyThrows
    public void start() {
        System.out.println("---方法 start 开始调用---");
        for (int index = 1; index <= 10; ++index) {
            Thread.sleep(1000); // 每次休眠 1 秒

            if (onReceiveHandler == null) {
                continue; // 如果使用者没有提供回调，什么也不做
            }

            var msgData = new HashMap<String, Object>(1);
            msgData.put("text", "接收到第 " + index + " 条信息");
            onReceiveHandler.handle(new Event(msgData));
        }

        System.out.println("***方法 start 结束调用***");
    }
}
