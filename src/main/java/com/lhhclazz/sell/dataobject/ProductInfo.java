package com.lhhclazz.sell.dataobject;

import com.lhhclazz.sell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    /** 商品id */
    @Id
    private String productId;

    /** 商品名字 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 小图片 */
    private String productIcon;

    /** 商品状态 0上架 ,1下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 商品的编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
