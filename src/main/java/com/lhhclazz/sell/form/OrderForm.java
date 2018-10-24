package com.lhhclazz.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 校验订单表单数据
 */
@Data
public class OrderForm {

    /** 买家姓名必填 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家电话必填 */
    @NotEmpty(message = "电话必填")
    private String phone;

    /** 买家地址必填 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家的微信id必填 */
    @NotEmpty(message = "openid必填")
    private String openid;

    /** 买家购物车必填 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
