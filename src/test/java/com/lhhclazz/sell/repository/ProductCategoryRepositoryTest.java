package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.ProductCategory;
import org.hibernate.criterion.Example;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findTest(){
        List<ProductCategory> category = repository.findAll();
        System.out.println(category);
    }

    @Test
    public void savaTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(2);
        repository.save(productCategory);
    }
    @Test
    public void updateTest(){

        ProductCategory productCategory = repository.findByCategoryId(1);
        Assert.assertNotNull(productCategory);
        System.out.println(productCategory.toString());
    }

}