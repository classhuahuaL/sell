package com.lhhclazz.sell.repository;

import com.lhhclazz.sell.dataobject.ProductCategory;
import com.lhhclazz.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品dao
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    /** 根据id查询一条商品类目记录*/
    ProductInfo findByProductId(String productId);

    /** 根据商品的状态查询 */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
