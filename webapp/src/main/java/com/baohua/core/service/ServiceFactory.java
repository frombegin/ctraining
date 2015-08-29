package com.baohua.core.service;

/**
 * 服务工厂接口
 * 
 * @author $Id$
 */
public interface ServiceFactory {

    /**
     * 创建服务对象实例
     * 
     * @return 服务对象实例
     */
    Service createService();
}
