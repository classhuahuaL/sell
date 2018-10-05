package com.lhhclazz.sell.dto;

import com.lhhclazz.sell.dataobject.OrderDetail;
import com.lhhclazz.sell.enums.OrderStatusEnum;
import com.lhhclazz.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用于数据传输的dto
 */
@Data
public class OrderDTO {


    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家手机 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家的微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态 0新下单 1完结订单 */
    private Integer orderStatus;

    /** 订单的支付状态 0未支付 1已支付 */
    private Integer payStatus;

    /** 订单创建时间 */
    private Date createTime;

    /** 订单的更新时间 */
    private Date updateTime;

    /** 一个订单对应的多条商品 */
    private List<OrderDetail> orderDetailList;
}
