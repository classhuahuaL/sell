package com.lhhclazz.sell.enums;

import lombok.Getter;

/**
 * 订单状态枚举
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新下单"),
    FINISHED(1,"已支付"),
    CANCEL(2,"已取消"),
    ;
    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
