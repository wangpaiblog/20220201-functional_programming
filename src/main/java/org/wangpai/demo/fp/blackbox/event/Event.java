package org.wangpai.demo.fp.blackbox.event;

import java.util.Map;
import lombok.Getter;

@Getter
public class Event {
    /**
     * value 为具体的数据，key 为为 value 而起的名字
     *
     * @since 2021-11-24
     */
    private Map<String, Object> data;

    public Event(Map<String, Object> data) {
        super();
        this.data = data;
    }
}
