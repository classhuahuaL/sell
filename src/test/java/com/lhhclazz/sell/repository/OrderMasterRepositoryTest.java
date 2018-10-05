package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;


    @Test
    public void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("zhoucc");
        orderMaster.setBuyerPhone("17688912424");
        orderMaster.setBuyerAddress("四川");
        orderMaster.setBuyerOpenid("lhh10022");
        orderMaster.setOrderAmount(new BigDecimal(4.1));
        repository.save(orderMaster);
    }


    @Test
    public void test01(){
        PageRequest pageRequest = new PageRequest(0,2);

        Page<OrderMaster> openid = repository.findByBuyerOpenid("lhh10022", pageRequest);
        System.out.println(openid.getTotalElements());
    }

}