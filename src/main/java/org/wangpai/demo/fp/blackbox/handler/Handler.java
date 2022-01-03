package org.wangpai.demo.fp.blackbox.handler;

import org.wangpai.demo.fp.blackbox.event.Event;

/**
 * @since 2021-12-31
 */
@FunctionalInterface
public interface Handler {
    void handle(Event event);
}
