package com.duoermei.healthcommons.enumeration;

/**
 * @Description: 支付状态
 * @Author GoldFu
 * @Date 2019/6/3
 * @Version V1.0
 **/
public enum PayStatus {
    /**
     * 初始化
     */
    INITIALIZATION,
    /**
     * 处理中
     */
    PROCESSING,
    /**
     * 支付中
     */
    PAYING,
    /**
     * 退款中
     */
    RETREAT,
    /**
     * 成功
     */
    SUCCESS,
    /**
     * 失败
     */
    FAILURE,
    /**
     * 关闭
     */
    SHUT_DOWN,
}
