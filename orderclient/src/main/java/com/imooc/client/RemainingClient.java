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
 * Created by MySelf on 2018/12/13.
 */
@Component
@FeignClient(name = "remaining-client")
public interface RemainingClient {

    @GetMapping("/is_has_user")
    Integer isHasUser(@RequestParam("id") Integer id);

    @GetMapping("/is_has_goods")
    Integer isHasGoods(@RequestParam("goodsId") String goodsId);

    @GetMapping("/find_by_goods_id")
    InventoryDTO findByGoodsId(@RequestParam("goodsId") String goodsId);

    @GetMapping("/get_goods_price")
    BigDecimal getGoodsPrice(@RequestParam("goodsId") String goodsId);

    @PostMapping("/to_save")
    void toSave(@RequestBody InventoryDTO inventory);

    @GetMapping("/get_user_name")
    String getUserName(@RequestParam("id") Integer id);
}
