package com.imooc.repository;

import com.imooc.dataobject.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 库存表数据库操作
 * Created by MySelf on 2018/12/12.
 */
public interface InventoryRepository extends JpaRepository<Inventory, String> {

    Inventory findByGoodsId(String goodsId);

}
