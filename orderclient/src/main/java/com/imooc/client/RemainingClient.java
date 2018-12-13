package com.imooc.client;

import com.imooc.dto.InventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * 向Remaining服务发起请求
 * Created by MySelf on 2018/12/13.
 */
@Component
@FeignClient(name = "remaining-client")
public interface RemainingClient {

    /**
     * 判断用户是否存在
     * @param id {@link Integer} 用户id
     * @return {@link Integer} 数据库存在数量
     */
    @GetMapping("/is_has_user")
    Integer isHasUser(@RequestParam("id") Integer id);

    /**
     * 判断订单是否存在
     * @param goodsId {@link String} 订单号
     * @return {@link Integer} 数据库存在数量
     */
    @GetMapping("/is_has_goods")
    Integer isHasGoods(@RequestParam("goodsId") String goodsId);

    /**
     * 根据商品id获取库存对象DTO
     * @param goodsId {@link String} 商品Id
     * @return {@link InventoryDTO} 库存对象DTO
     */
    @GetMapping("/find_by_goods_id")
    InventoryDTO findByGoodsId(@RequestParam("goodsId") String goodsId);

    /**
     * 根据商品di获取商品单价
     * @param goodsId {@link String} 商品ID
     * @return {@link BigDecimal} 商品单价
     */
    @GetMapping("/get_goods_price")
    BigDecimal getGoodsPrice(@RequestParam("goodsId") String goodsId);

    /**
     * 保存更新库存
     * @param inventory {@link InventoryDTO} 库存DTO
     */
    @PostMapping("/to_save")
    void toSave(@RequestBody InventoryDTO inventory);

    /**
     * 根据用户ID获取用户名
     * @param id {@link Integer} 用户id
     * @return {@link String} 用户名
     */
    @GetMapping("/get_user_name")
    String getUserName(@RequestParam("id") Integer id);
}
