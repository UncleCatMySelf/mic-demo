package com.imooc.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表 Bean
 * Created by MySelf on 2018/12/12.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Goods {

    /** 商品ID */
    @Id
    private String goodsId;

    /** 商品名 */
    private String goodsName;

    /** 商品信息 */
    private String goodsDetail;

    /** 商品价格 */
    private BigDecimal goodsPrice;

    /** 创建时间 */
    private Date createTime;
}
