package com.imooc.controller;

import com.imooc.dataobject.Inventory;
import com.imooc.repository.GoodsRepository;
import com.imooc.repository.InventoryRepository;
import com.imooc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by MySelf on 2018/12/13.
 */
@RestController
public class ClientController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping("/is_has_user")
    public Integer isHasUser(@RequestParam("id") Integer id){
        return userRepository.countById(id);
    }

    @GetMapping("/is_has_goods")
    public Integer isHashGoods(@RequestParam("goodsId") String goodsId){
        return goodsRepository.countByGoodsId(goodsId);
    }

    @GetMapping("/find_by_goods_id")
    public Inventory findByGoodsId(@RequestParam("goodsId") String goodsId){
        return inventoryRepository.findByGoodsId(goodsId);
    }

    @GetMapping("/get_goods_price")
    public BigDecimal getGoodsPrice(@RequestParam("goodsId") String goodsId){
        return goodsRepository.getOne(goodsId).getGoodsPrice();
    }

    @PostMapping("/to_save")
    public void toSave(@RequestBody Inventory inventory){
        inventoryRepository.save(inventory);
    }

    @GetMapping("/get_user_name")
    public String getUserName(@RequestParam("id") Integer id){
        return userRepository.getOne(id).getName();
    }
}
