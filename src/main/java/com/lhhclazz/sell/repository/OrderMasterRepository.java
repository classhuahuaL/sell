package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.OrderMaster;
import com.lhhclazz.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单dao
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    OrderMaster findByOrderId(String orderId);

    /** 根据买家微信号和分页信息返回分页对象 */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenId, Pageable pageable);
}
