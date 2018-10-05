package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.OrderDetail;
import com.lhhclazz.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * 订单商品dao
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

    OrderDetail findByDetailId(String detailId);

    /** 根据订单号查询 */
    List<OrderDetail> findByOrderId(String orderId);
}
