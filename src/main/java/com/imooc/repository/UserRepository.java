package com.imooc.repository;

import com.imooc.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户表数据库操作
 * Created by MySelf on 2018/12/12.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
