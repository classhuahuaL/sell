package com.lhhclazz.sell.dto;

import lombok.Data;

/**
 * 曾删库存
 */
@Data
public class CartDTO {

    /** 库存数量 */
    private Integer productStock;

    /** 商品id */
    private String productId;

    public CartDTO(Integer productStock, String productId) {
        this.productStock = productStock;
        this.productId = productId;
    }
}
