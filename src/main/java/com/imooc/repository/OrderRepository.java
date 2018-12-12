package com.imooc.repository;

import com.imooc.dataobject.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单表数据库操作
 * Created by MySelf on 2018/12/12.
 */
public interface OrderRepository extends JpaRepository<Order, String> {
}
