package com.lhhclazz.sell.service.impl;

import com.lhhclazz.sell.dataobject.ProductCategory;
import com.lhhclazz.sell.repository.ProductCategoryRepository;
import com.lhhclazz.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
//@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findByCategoryId(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public void save(ProductCategory productCategory) {
        if(!StringUtils.isEmpty(productCategory.getCategoryName()) && !StringUtils.isEmpty(productCategory.getCategoryType()))  repository.save(productCategory);
    }
}
