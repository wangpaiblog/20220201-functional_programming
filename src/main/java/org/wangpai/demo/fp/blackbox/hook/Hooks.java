package org.wangpai.demo.fp.blackbox.hook;

import org.wangpai.demo.fp.blackbox.event.Event;

/**
 * @since 2021-12-31
 */
public interface Hooks {
    void onReceive(Event event);

    void onDestroy(Event event);
}
