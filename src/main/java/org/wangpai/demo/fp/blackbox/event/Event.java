package org.wangpai.demo.fp.blackbox.event;

import java.util.HashMap;
import java.util.Map;

/**
 * @since 2021-12-31
 */
public class Event {
    private Map<DataType, Object> data;

    private Event() {
        super();
        this.data = new HashMap<>(2);
    }

    public Object getData(DataType dataType) {
        return data.get(dataType);
    }

    public Event setData(DataType dataType, Object data) {
        this.data.put(dataType, data);
        return this;
    }

    public static Event getInstance() {
        return new Event();
    }
}
