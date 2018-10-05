package com.lhhclazz.sell.service.impl;

import com.lhhclazz.sell.dataobject.ProductInfo;
import com.lhhclazz.sell.service.ProductService;
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
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findOne() {
        ProductInfo info = productService.findOne("123456");
        System.out.println(info);
    }

    @Test
    public void findAll() {
        PageRequest pageRequest = new PageRequest(0,1);
        Page<ProductInfo> infoPage = productService.findAll(pageRequest);
        System.out.println(infoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1234567");
        productInfo.setProductName("皮蛋粥");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://xxxxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        productService.save(productInfo);
    }
}