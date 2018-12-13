package com.imooc.controller;

import com.imooc.dataobject.Inventory;
import com.imooc.repository.GoodsRepository;
import com.imooc.repository.InventoryRepository;
import com.imooc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * 对接外部服务接口
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

    /**
     * 判断用户是否存在
     * @param id {@link Integer} 用户id
     * @return {@link Integer} 数据库存在数量
     */
    @GetMapping("/is_has_user")
    public Integer isHasUser(@RequestParam("id") Integer id){
        return userRepository.countById(id);
    }

    /**
     * 判断订单是否存在
     * @param goodsId {@link String} 订单号
     * @return {@link Integer} 数据库存在数量
     */
    @GetMapping("/is_has_goods")
    public Integer isHashGoods(@RequestParam("goodsId") String goodsId){
        return goodsRepository.countByGoodsId(goodsId);
    }

    /**
     * 根据商品id获取库存对象
     * @param goodsId {@link String} 商品Id
     * @return {@link Inventory} 库存对象
     */
    @GetMapping("/find_by_goods_id")
    public Inventory findByGoodsId(@RequestParam("goodsId") String goodsId){
        return inventoryRepository.findByGoodsId(goodsId);
    }

    /**
     * 根据商品di获取商品单价
     * @param goodsId {@link String} 商品ID
     * @return {@link BigDecimal} 商品单价
     */
    @GetMapping("/get_goods_price")
    public BigDecimal getGoodsPrice(@RequestParam("goodsId") String goodsId){
        return goodsRepository.getOne(goodsId).getGoodsPrice();
    }

    /**
     * 保存更新库存
     * @param inventory {@link Inventory} 库存
     */
    @PostMapping("/to_save")
    public void toSave(@RequestBody Inventory inventory){
        inventoryRepository.save(inventory);
    }

    /**
     * 根据用户ID获取用户名
     * @param id {@link Integer} 用户id
     * @return {@link String} 用户名
     */
    @GetMapping("/get_user_name")
    public String getUserName(@RequestParam("id") Integer id){
        return userRepository.getOne(id).getName();
    }
}
