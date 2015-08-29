package com.baohua.core.service;

/**
 * 服务定位接口
 * 
 * @author $Id$
 */
public interface ServiceLocator {

    /**
     * 获取服务对象实例
     * 
     * @param <T>
     * @param id 服务标识符
     * @return 服务实例
     * @throws ServiceNotFoundException 
     */
    <T extends Service> T getService(ServiceType id) throws ServiceNotFoundException;
}
