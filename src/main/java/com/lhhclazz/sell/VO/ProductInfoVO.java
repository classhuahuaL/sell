package com.lhhclazz.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 商品的详细信息
 */
@Data
public class ProductInfoVO {

    /** 商品的id */
    @JsonProperty("id")
    private String productId;

    /** 商品的名字 */
    @JsonProperty("name")
    private String productName;

    /** 商品的价格 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 商品的描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 商品的小图 */
    @JsonProperty("icon")
    private String productIcon;
}
