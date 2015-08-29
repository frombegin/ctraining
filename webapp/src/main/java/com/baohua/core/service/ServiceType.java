package com.baohua.core.service;


/**
 * 服务类型枚举
 * 
 * @author $Id$
 */
public enum ServiceType {
  // 全局服务
  /**
   * 短信服务
   */
  SMS,
  /**
   * JDBC连接池服务
   */
  CONNECTION_POOL,
  /**
   * 手机验证码服务(Moblile Verification Code)
   */
  MVC,

  // 会话服务
  /**
   * 验证服务
   */
  AUTHENTICATION,
  /**
   * 用户服务
   */
  USER,
  /**
   * 商业团队服务
   */
  BIZTEAM,
  /**
   * 认证相关服务
   */
  CERTIFICATION,
  /**
   * 消息服务
   */
  MESSAGE,
  /**
   * 会话服务
   */
  SESSION,
  /**
   * 图片服务
   */
  IMAGE,
  /**
   * 
   */
  WALLOT, 
  /**
   * 文件服务
   */
  FILE,
  /**
   *  店铺服务
   */
  SHOP
}
