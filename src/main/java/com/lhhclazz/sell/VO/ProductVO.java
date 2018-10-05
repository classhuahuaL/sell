package com.lhhclazz.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lhhclazz.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 * 商品类别
 */
@Data
public class ProductVO {

    /** 商品类目名称 */
    @JsonProperty("name")
    private String categoryName;

    /** 类目的编号 */
    @JsonProperty("type")
    private Integer categoryType;

    /** 类目下的商品详细信息 */
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
