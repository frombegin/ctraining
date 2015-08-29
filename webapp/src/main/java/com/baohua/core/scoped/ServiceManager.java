package com.baohua.core.scoped;

import com.baohua.core.service.*;

import java.util.EnumMap;
import java.util.Map;

public class ServiceManager implements ServiceLocator {
    protected final Map<ServiceType, Service> services = new EnumMap<>(ServiceType.class);

    public Map<ServiceType, Service> getServices() {
        return services;
    }

    protected final Map<ServiceType, ServiceFactory> factories = new EnumMap<>(ServiceType.class);

    public ServiceManager() {
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
    @SuppressWarnings("unchecked cast")
    public <T extends Service> T getService(ServiceType id) throws ServiceNotFoundException {
        if (!this.services.containsKey(id)) {
            if (!this.factories.containsKey(id)) {
                throw new ServiceNotFoundException("指定的服务不存在" + id);
            }

            Service service = this.factories.get(id).createService();
            this.services.put(id, service);
            if (service instanceof ScopedService) {
                ScopedService tmp = (ScopedService) service;
                tmp.startup(null); // 启动 ScopedService
            }
        }

        return (T) services.get(id);
    }

    public void close() {
        for (Service srv : this.services.values()) {
            ScopedService tmp = (ScopedService) srv;
            tmp.shutdown();
        }
    }
}