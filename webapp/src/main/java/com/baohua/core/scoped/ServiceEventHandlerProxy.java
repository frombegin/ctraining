package com.baohua.core.scoped;

import com.baohua.core.scoped.event.Event;
import com.baohua.core.scoped.event.EventHandler;
import com.baohua.core.service.ServiceNotFoundException;
import com.baohua.core.service.ServiceType;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 将事件转发给服务的代理
 * 
 * 缺省的会话中的服务是不会自动创建的，只有使用到的服务才会被创建。
 * 此代理会记录事件发送到的目标服务名称，如果事件发生，则会通过
 * 会话上下文获取（或者创建）服务，然后将事件转发给此服务。
 * 
 * @author $Id$
 */
class ServiceEventHandlerProxy implements EventHandler {
    private final ScopedContext context;
    private final ServiceType serviceName;

    public ServiceEventHandlerProxy(ScopedContext context, ServiceType serviceName) {
        this.context = context;
        this.serviceName = serviceName;
    }

    @Override
    public boolean handleEvent(Event evt) {
        try {
            EventHandler handler = (EventHandler)this.context.getService(this.serviceName);
            return handler.handleEvent(evt);
        } catch (ServiceNotFoundException ex) {
            // TODO: 处理没有指定的服务
            Logger.getLogger(ServiceEventHandlerProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
