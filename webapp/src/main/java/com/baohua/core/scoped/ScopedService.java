package com.baohua.core.scoped;

import com.baohua.core.service.Service;

/**
 * 会话服务
 *
 * 存在于会话的服务, 会话期间如果使用到了此类服务，服务会被构造并且设置相应
 * 的会话上下文; 如果被构造，会话结束时会自动释放此类服务;
 *
 * @author $Id$
 */
public interface ScopedService extends Service {

    /**
     * 启动服务
     *
     * @param context 会话上下文对象实例
     */
    void startup(ScopedContext context);

    /**
     * 终止服务
     */
    void shutdown();
}
