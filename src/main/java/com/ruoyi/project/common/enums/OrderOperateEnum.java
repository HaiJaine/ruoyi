package com.ruoyi.project.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单操作
 *
 * @author wangdong
 * @date 2020-05-13
 */
@AllArgsConstructor
@Getter
public enum OrderOperateEnum {

    /**
     * 后台端发送空箱
     */
    BACKEND_SEND_EMPTY("backend", 2, "发送空箱"),

    /**
     * 手机端收取空箱
     */
    APP_GET_EMPTY("app", 3, "收取空箱"),

    /**
     * 手机端发送重箱
     */
    APP_SEND_HEAVY("app", 4, "发送重箱"),

    /**
     * 后台端发送空箱
     */
    BACKEND_GET_HEAVY("backend", 5, "发送空箱"),

    /**
     * 手机端预约提取
     */
    APP_ORDER_GET("app", 6, "预约提取"),

    /**
     * 后台端发送重箱
     */
    BACKEND_SEND_HEAVY("backend", 7, "发送重箱"),

    /**
     * 手机端收取重箱
     */
    APP_GET_HEAVY("app", 8, "收取重箱"),

    /**
     * 手机端发送空箱
     */
    APP_SEND_EMPTY("app", 9, "发送空箱"),

    /**
     * 后台端收取空箱
     */
    BACKEND_GET_EMPTY("backend", 10, "收取空箱"),

    /**
     * 手机端删除订单
     */
    APP_DEL_ORDER("app", 10, "删除订单");

    /**
     * 终端
     */
    private String terminal;

    /**
     * 操作
     */
    private Integer operate;

    /**
     * 说明
     */
    private String tag;

    /**
     * 通过终端和操作获取枚举
     *
     * @param terminal 终端
     * @param operate  操作
     * @return 枚举对象
     */
    public static OrderOperateEnum getOrderOperateEnum(String terminal, Integer operate) {
        // 循环遍历
        for (OrderOperateEnum orderOperateEnum : OrderOperateEnum.values()) {
            // 若当前对象的终端和操作与传入的值相同，则返回当前枚举对象
            if (terminal.equals(orderOperateEnum.getTerminal()) && operate.equals(orderOperateEnum.getOperate())) {
                // 返回枚举对象
                return orderOperateEnum;
            }
        }
        // 默认返回为空
        return null;
    }

}
