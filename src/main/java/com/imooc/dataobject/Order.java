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
 * 订单表 Bean
 * Created by MySelf on 2018/12/12.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class Order {

    /** 订单号 */
    @Id
    private String orderId;

    /** 商品id */
    private String goodsId;

    /** 用户名 */
    private String name;

    /** 订单总价 */
    private BigDecimal orderPrice;

    /** 商品总数 */
    private Integer orderNum;

    /** 创建时间 */
    private Date createTime;

}
