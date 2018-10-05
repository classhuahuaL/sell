package com.lhhclazz.sell.dataobject;

import com.lhhclazz.sell.enums.OrderStatusEnum;
import com.lhhclazz.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
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
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 订单的支付状态 0未支付 1已支付 */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 订单创建时间 */
    private Date createTime;

    /** 订单的更新时间 */
    private Date updateTime;
}
