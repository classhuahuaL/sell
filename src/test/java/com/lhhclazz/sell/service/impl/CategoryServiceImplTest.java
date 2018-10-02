package com.lhhclazz.sell.service.impl;

import com.lhhclazz.sell.dataobject.ProductCategory;
import com.lhhclazz.sell.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(1);
        System.out.println(category);
    }

    @Test
    public void findAll() {
        List<ProductCategory> categoryList = categoryService.findAll();
        System.out.println(categoryList);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> ids = Arrays.asList(1,2,3);
        List<ProductCategory> byCategoryTypeIn = categoryService.findByCategoryTypeIn(ids);
        System.out.println(byCategoryTypeIn);
    }

    @Test
//    @Transactional
    public void save() {
        ProductCategory category = new ProductCategory();
        category.setCategoryId(1);
        category.setCategoryName("女生最爱");
        category.setCategoryType(4);
        categoryService.save(category);
    }
}