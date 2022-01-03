package org.wangpai.demo.fp.blackbox;

import lombok.SneakyThrows;
import org.wangpai.demo.fp.blackbox.event.DataType;
import org.wangpai.demo.fp.blackbox.event.Event;

/**
 * @since 2021-12-31
 */
public class MockServer extends OnServerAction {
    @SneakyThrows
    public void start() {
        System.out.println("---方法 start 开始调用---");
        for (int index = 1; index <= 10; ++index) {
            Thread.sleep(1000); // 每次休眠 1 秒

            if (this.getOnReceiveHandler() == null) {
                continue; // 如果使用者没有提供回调，什么也不做
            }

            var event = Event.getInstance();
            var dataType = DataType.TEXT;
            event.setData(DataType.DATA_TYPE, dataType);
            event.setData(dataType, "接收到第 " + index + " 条信息");
            this.onReceive(event);
        }

        if (this.getOnDestroyHandler() != null) {
            this.onDestroy(null);
        }
        System.out.println("***方法 start 结束调用***");
    }
}
