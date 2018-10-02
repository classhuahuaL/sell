package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目dao
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    /** 根据id查询一条商品类目记录*/
    ProductCategory findByCategoryId(Integer categoryId);

    /** 根据商品类目编号查询类目记录 */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
