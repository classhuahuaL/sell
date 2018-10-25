package com.lhhclazz.sell.service;

import com.lhhclazz.sell.dto.OrderDTO;

/**
 * @author huahua
 * email:laihuahua07@163.com
 * @create 2018-10-24 下午8:36
 * @desc
 **/
public interface BuyerService {

    /** 取消订单 */
    OrderDTO cancel(String openid, String orderId);

    /** 查询商品详情 */
    OrderDTO findOne(String openid,String orderId);
}
