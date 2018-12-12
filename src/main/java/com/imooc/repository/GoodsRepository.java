package com.imooc.repository;

import com.imooc.dataobject.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 商品表数据库操作
 * Created by MySelf on 2018/12/12.
 */
public interface GoodsRepository extends JpaRepository<Goods, String> {

}
