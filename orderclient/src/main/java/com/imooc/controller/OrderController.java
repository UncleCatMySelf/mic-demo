package com.imooc.controller;

import com.imooc.client.RemainingClient;
import com.imooc.dataobject.Orders;
import com.imooc.dto.InventoryDTO;
import com.imooc.repository.OrderRepository;
import com.imooc.utils.KeyUtil;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by MySelf on 2018/12/12.
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RemainingClient remainingClient;

    //下单
    @PostMapping("/order")
    public ResultVO order(@RequestParam("id") Integer id,@RequestParam("goodsId") String goodsId, @RequestParam("num") Integer num){
        //判断用户是否存在
        if(remainingClient.isHasUser(id) == 0){
            return ResultVOUtil.error(444,"用户不存在");
        }
        //判断商品是否存在
        if(remainingClient.isHasGoods(goodsId) == 0){
            return ResultVOUtil.error(445,"商品不存在");
        }
        //库存是否足够
        InventoryDTO inventory = remainingClient.findByGoodsId(goodsId);
        if ((inventory.getInventoryNum() - num) < 0){
            return ResultVOUtil.error(446,"库存不足");
        }
        BigDecimal sum = remainingClient.getGoodsPrice(goodsId).multiply(new BigDecimal(num));
        //减库存
        inventory.setInventoryNum(inventory.getInventoryNum()-num);
        remainingClient.toSave(inventory);
        //下单
        Orders orders = new Orders(KeyUtil.getMobookKey(4),goodsId,remainingClient.getUserName(id),sum,num,new Date());
        Orders orderResult = orderRepository.save(orders);
        return ResultVOUtil.success(orderResult.getOrderId());
    }

    //查询订单
    @GetMapping("/order")
    public ResultVO order(@RequestParam("id") Integer id){
        //判断用户是否存在
        if(remainingClient.isHasUser(id) == 0){
            return ResultVOUtil.error(444,"用户不存在");
        }
        //根据用户信息查询订单列表
        List<Orders> orders = orderRepository.findAllByName(remainingClient.getUserName(id));
        return ResultVOUtil.success(orders);
    }

}
