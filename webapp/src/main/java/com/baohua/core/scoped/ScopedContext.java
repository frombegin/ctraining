package com.baohua.core.scoped;

import com.baohua.common.util.ValueMap;

import com.baohua.common.util.ValueMapAggregate;
import com.baohua.common.util.ValueMapImpl;
import com.baohua.core.scoped.event.Event;
import com.baohua.core.scoped.event.EventDispatcher;
import com.baohua.core.scoped.event.EventDispatcherAggregate;
import com.baohua.core.scoped.event.EventDispatcherImpl;

import com.baohua.core.service.Service;
import com.baohua.core.service.ServiceFactory;
import com.baohua.core.service.ServiceLocator;
import com.baohua.core.service.ServiceNotFoundException;
import com.baohua.core.service.ServiceType;

import com.baohua.services.user.User;


/**
 * 会话上下文对象
 * <p>
 * 此对象主要功能有：
 * 1、管理会话期间的服务的注册、创建、定位等
 * 2、会话期间内共享的数据字典（键、值）
 * 3、会话期间的启动与终止
 *
 * @author $Id$
 */
public class ScopedContext implements Scoped, ServiceLocator, ValueMapAggregate, EventDispatcherAggregate {

    protected final ServiceManager serviceManager = new ServiceManager();
    protected final ValueMap valueMap = new ValueMapImpl();

    // 当前用户
    private User currentUser;  // TODO: 如何获取，外部传入？

    // 事件派发器
    private final EventDispatcher eventDispatcher = new EventDispatcherImpl();

    public ScopedContext() {
        // 代理全局服务
//    this.services.put(ServiceType.CONNECTION_POOL, GlobalContext.INSTANCE.getConnPollService());
//    this.services.put(ServiceType.SMS, GlobalContext.INSTANCE.getSmsService());
//    this.services.put(ServiceType.MVC, GlobalContext.INSTANCE.getMvcodeService());
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public void registerServiceFactory(ServiceType type, ServiceFactory factory) {
        serviceManager.registerServiceFactory(type, factory);
    }

    /**
     * 通过服务类型获取服务
     *
     * @param id 服务标识符
     * @return 服务
     * @throws ServiceNotFoundException
     */
    @Override
    public <T extends Service> T getService(ServiceType id) throws ServiceNotFoundException {
        return serviceManager.getService(id);
    }

    @Override
    public void open() {
        // 注册服务工厂

        // 注册事件处理器
    }

    @Override
    public void close() {
        this.serviceManager.close();
    }

    public void sendEvent(Event event) {
        this.eventDispatcher.dispatchEvent(event);
    }

    @Override
    public EventDispatcher getEventDispatcher() {
        return this.eventDispatcher;
    }

    private void registerServiceEventHandler(String eventId, ServiceType serviceName) {
        // 辅助方法
        this.eventDispatcher.registerEventHandler(eventId, new ServiceEventHandlerProxy(this, serviceName));
    }

    @Override
    public ValueMap getValueMap() {
        return this.valueMap;
    }
}
