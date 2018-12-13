package com.imooc.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户表 Bean
 * Created by MySelf on 2018/12/12.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
public class User {

    /** 用户id 自增 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 用户名 */
    private String name;

    /** 用户密码 */
    private String password;

    /** 创建时间 */
    private Date createTime;

}
