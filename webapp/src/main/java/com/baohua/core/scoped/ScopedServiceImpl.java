package com.baohua.core.scoped;

/**
 * 会话服务的实现基类
 * <p>
 * 一般情况下，其它会话区间服务应该从此类派生.
 *
 * @author $Id$
 */
public abstract class ScopedServiceImpl implements ScopedService {

  protected ScopedContext context;    // 子类使用此字段访问会话上下文对象

  /**
   * 启动服务.
   * 注意: 在服务类上, 构造和启动不是一个过程.
   * @param context 会话上下文对象实例
   */
  @Override
  public void startup(ScopedContext context) {
    this.context = context;
  }

  @Override
  public void shutdown() {
    this.context = null;    // 解除引用!
  }

}
