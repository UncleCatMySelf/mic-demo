package com.imooc.controller;

import com.imooc.repository.GoodsRepository;
import com.imooc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by MySelf on 2018/12/12.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    //管理员查询库存



}
