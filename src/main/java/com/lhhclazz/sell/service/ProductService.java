package com.lhhclazz.sell.service;

import com.lhhclazz.sell.dataobject.ProductInfo;
import com.lhhclazz.sell.dto.CartDTO;
import com.lhhclazz.sell.enums.ProductStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

/**
 * 商品service
 */
public interface ProductService {

    /** 根据商品的id查询 */
    ProductInfo findOne(String productId);

    /** 查询所有数据并且分页 */
    Page<ProductInfo> findAll(Pageable pageable);

    /** 查询已上架的商品 */
    List<ProductInfo> findUpAll();

    /** 添加商品或者更新 */
    void save(ProductInfo productInfo);

    /** 添加库存 */
    void increaseStock(List<CartDTO> cartDTOList);

    /** 减库存 */
    void decreaseStock(List<CartDTO> cartDTOList);

    /** 上架 */
    ProductInfo onSale(String productId);

    /** 下架 */
    ProductInfo offSale(String productId);

}
