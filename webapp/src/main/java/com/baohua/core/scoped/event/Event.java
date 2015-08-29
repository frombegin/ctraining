package com.baohua.core.scoped.event;

import com.baohua.common.util.ValueMap;
import java.util.HashMap;
import java.util.Map;

public final class Event implements ValueMap {

    private final String id;
    private final Object sender;

    public Event(String id, Object sender) {
        this.id = id;
        this.sender = sender;
    }

    public String getId() {
        return id;
    }

    public Object getSender() {
        return sender;
    }

    protected final Map<String, Object> values = new HashMap<>();

    @Override
    public Object getValue(String key) {
        return this.values.get(key);
    }

    @Override
    public void setValue(String key, Object value) {
        this.values.put(key, value);
    }

    @Override
    public boolean hasValue(String key) {
        return this.values.containsKey(key);
    }

}
