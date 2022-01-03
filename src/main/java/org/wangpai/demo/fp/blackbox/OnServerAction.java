package org.wangpai.demo.fp.blackbox;

import org.wangpai.demo.fp.blackbox.event.Event;
import org.wangpai.demo.fp.blackbox.handler.Handler;
import org.wangpai.demo.fp.blackbox.handler.Handlers;

/**
 * @since 2021-12-31
 */
public abstract class OnServerAction extends Handlers {
    public final void setOnReceive(Handler handler) {
        this.setOnReceiveHandler(handler);
    }

    public final void onReceive(Event event) {
        this.handle(this.getOnReceiveHandler(), event);
    }

    public final void setOnDestroy(Handler handler) {
        this.setOnDestroyHandler(handler);
    }

    public final void onDestroy(Event event) {
        this.handle(this.getOnDestroyHandler(), event);
    }

    private void handle(Handler handler, Event event) {
        if (handler != null) {
            handler.handle(event);
        }
    }
}
