package org.wangpai.demo.fp.blackbox;

import java.util.concurrent.Executors;
import org.wangpai.demo.fp.blackbox.event.DataType;
import org.wangpai.demo.fp.blackbox.event.Event;
import org.wangpai.demo.fp.blackbox.hook.Hooks;

/**
 * @since 2021-12-31
 */
public class MockServerTest {
    public static void main(String[] args) {
        final var executor = Executors.newCachedThreadPool();

        var hooks = new Hooks() {
            @Override
            public void onReceive(Event event) {
                var dataType = (DataType) event.getData(DataType.DATA_TYPE);
                System.out.println("来自服务器的反馈：" + event.getData(dataType));
            }

            @Override
            public void onDestroy(Event event) {
                System.out.println("服务器停止信息接收");
                executor.shutdown();
            }
        };
        var server = new MockServer();
        server.setHooks(hooks);

        executor.execute(() -> server.start());
        System.out.println("***方法 main 结束调用***");
    }
}