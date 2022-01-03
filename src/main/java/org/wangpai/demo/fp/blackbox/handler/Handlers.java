package org.wangpai.demo.fp.blackbox.handler;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.wangpai.demo.fp.blackbox.hook.Hooks;

/**
 * @since 2021-12-31
 */
@Setter(AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
@Accessors(chain = true)
public abstract class Handlers {
    private Handler onReceiveHandler;

    private Handler onDestroyHandler;

    public Handlers setHooks(Hooks hooks) {
        this.onReceiveHandler = hooks::onReceive;
        this.onDestroyHandler = hooks::onDestroy;

        return this;
    }
}
