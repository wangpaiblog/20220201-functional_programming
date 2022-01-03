package org.wangpai.demo.fp.blackbox.handler;

import org.wangpai.demo.fp.blackbox.event.Event;

@FunctionalInterface
public interface Handler {
    void handle(Event event);
}
