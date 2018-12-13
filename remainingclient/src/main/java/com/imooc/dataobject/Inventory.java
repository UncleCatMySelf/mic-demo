package com.imooc.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 库存表 Bean
 * Created by MySelf on 2018/12/12.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    /** 库存Id */
    @Id
    private String inventoryId;

    /** 商品Id */
    private String goodsId;

    /** 对应商品Id的库存总数 */
    private Integer inventoryNum;
}
