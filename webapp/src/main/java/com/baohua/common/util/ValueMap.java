package com.baohua.common.util;

/**
 * 数据字典接口
 * 
 * @author $Id$
 */
public interface ValueMap {

    /**
     * 获取指定键的值
     * 
     * @param key 键
     * @return 值或者null
     */
    Object getValue(String key);

    /**
     * 设置指定键的值
     * 
     * @param key 键
     * @param value 值
     */
    void setValue(String key, Object value);
    
    /**
     * 判断指定键是否存在
     * 
     * @param key 键
     * @return 存在时返回 true, 不存在返回 false
     */
    boolean hasValue(String key);
}
