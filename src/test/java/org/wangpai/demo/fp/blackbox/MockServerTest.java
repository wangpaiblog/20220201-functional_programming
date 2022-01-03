package org.wangpai.demo.fp.blackbox;

import java.util.concurrent.Executors;

public class MockServerTest {
    public static void main(String[] args) {
        var server = new MockServer();
        server.setOnReceiveHandler((event) -> System.out.println("来自服务器的反馈：" + event.getData().get("text")));

        Executors.newCachedThreadPool().execute(() -> server.start());
        System.out.println("***方法 main 结束调用***");
    }
}