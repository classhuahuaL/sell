package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("12345678");
        orderDetail.setOrderId("122222");
        orderDetail.setProductId("222222");
        orderDetail.setProductIcon("http://xxxx.png");
        orderDetail.setProductPrice(new BigDecimal(5.42));
        orderDetail.setProductQuantity(100);
        orderDetail.setProductName("橙子");
        repository.save(orderDetail);
    }
    @Test
    public void findTest(){
        List<OrderDetail> byOrderId = repository.findByOrderId("122222");
        System.out.println(byOrderId);
    }
}