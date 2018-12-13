package com.imooc.controller;

import com.imooc.dataobject.Inventory;
import com.imooc.repository.GoodsRepository;
import com.imooc.repository.InventoryRepository;
import com.imooc.repository.UserRepository;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MySelf on 2018/12/12.
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    //管理员查询库存
    @GetMapping("/goods")
    public ResultVO goods(@RequestParam("id") Integer id, @RequestParam("goodsId") String goodsId){
        //判断管理员身份
        if(userRepository.countById(id) == 0){
            return ResultVOUtil.error(444,"用户不存在");
        }
        //判断商品是否存在
        if(goodsRepository.countByGoodsId(goodsId) == 0){
            return ResultVOUtil.error(445,"商品不存在");
        }
        //根据商品号查询库存信息
        Inventory inventory = inventoryRepository.findByGoodsId(goodsId);
        return ResultVOUtil.success(inventory);
    }


}
