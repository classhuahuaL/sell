package com.lhhclazz.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /** category_id 商品类目主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** category_name 商品类目名称 */
    private String categoryName;

    /** category_type 商品类目的编号 */
    private Integer categoryType;

    /** create_time 商品类目创建的时间 */
    private Date createTime;

    /** update_time 商品类目更新的时间 */
    private Date updateTime;

}
