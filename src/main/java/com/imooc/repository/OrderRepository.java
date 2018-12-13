package com.imooc.repository;


import com.imooc.dataobject.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单表数据库操作
 * Created by MySelf on 2018/12/12.
 */
public interface OrderRepository extends JpaRepository<Orders, String> {

    List<Orders> findAllByName(String name);

}
