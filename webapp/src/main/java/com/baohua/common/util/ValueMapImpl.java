package com.baohua.common.util;

import com.baohua.common.util.ValueMap;

import java.util.HashMap;
import java.util.Map;

public class ValueMapImpl implements ValueMap {
    protected final Map<String, Object> values = new HashMap<>();

    public ValueMapImpl() {
    }

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