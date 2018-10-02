package com.lhhclazz.sell.service;

import com.lhhclazz.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目service
 */
public interface CategoryService {

    /** 根据id查询一条类目信息 */
    ProductCategory findOne(Integer categoryId);

    /** 查询所有类目信息 */
    List<ProductCategory> findAll();

    /** 根据类目编号查询类目 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /** 添加或者更新类目:有id则更新 无则添加 */
    void save(ProductCategory productCategory);

}
