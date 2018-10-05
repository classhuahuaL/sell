package com.lhhclazz.sell.service;

import com.lhhclazz.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单service
 */
public interface OrderService {

    /** 创建订单 */
    OrderDTO create(OrderDTO orderDTO);

    /** 根据订单id查询订单信息 */
    OrderDTO findOne(String orderId);

    /** 查询订单列表分页 */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单 */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单 */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单 */
    OrderDTO paid(OrderDTO orderDTO);

    /** 查询订单列表 */
    Page<OrderDTO> findList(Pageable pageable);

}
