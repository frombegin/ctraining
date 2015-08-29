package com.baohua.core.scoped;

/**
 * 区间接口 
 * 
 * 实现此接口的对象有明确的会话区间
 *
 * @author $Id$
 */
public interface Scoped {

    /**
     * 打开区间
     */
    void open();

    /**
     * 关闭区间
     */
    void close();

}
