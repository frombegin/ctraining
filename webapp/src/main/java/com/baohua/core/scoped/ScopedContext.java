package com.baohua.core.scoped;

import com.baohua.common.util.ValueMap;

import com.baohua.core.scoped.event.Event;
import com.baohua.core.scoped.event.EventDispatcher;
import com.baohua.core.scoped.event.EventDispatcherImpl;

import com.baohua.core.service.Service;
import com.baohua.core.service.ServiceFactory;
import com.baohua.core.service.ServiceLocator;
import com.baohua.core.service.ServiceNotFoundException;
import com.baohua.core.service.ServiceType;

import com.baohua.services.user.User;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


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
public class ScopedContext implements ValueMap, ServiceLocator, Scoped {

  // 服务相关
  protected final Map<ServiceType, Service> services = new EnumMap<>(ServiceType.class);
  protected final Map<ServiceType, ServiceFactory> factories = new EnumMap<>(ServiceType.class);

  // 会话数据相关
  protected final Map<String, Object> values = new HashMap<>();

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
    this.factories.put(type, factory);
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
    if (!this.services.containsKey(id)) {
      if (!this.factories.containsKey(id)) {
        throw new ServiceNotFoundException("指定的服务不存在" + id);
      }

      Service service = this.factories.get(id).createService();
      this.services.put(id, service);
      if (service instanceof ScopedService) {
        ScopedService tmp = (ScopedService) service;
        tmp.startup(this); // 启动 ScopedService
      }
    }

    return (T)services.get(id);
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

  @Override
  public void open() {
    // 注册服务工厂

    // 注册事件处理器
  }

  @Override
  public void close() {
    for(Service srv: this.services.values()) {
      ScopedService tmp = (ScopedService) srv;
      tmp.shutdown();
    }
  }

  public void sendEvent(Event event) {
    this.eventDispatcher.dispatchEvent(event);
  }

  public EventDispatcher getEventDispatcher() {
    return this.eventDispatcher;
  }

  private void registerServiceEventHandler(String eventId, ServiceType serviceName) {
    // 辅助方法
    this.eventDispatcher.registerEventHandler(eventId, new ServiceEventHandlerProxy(this, serviceName));
  }

}
