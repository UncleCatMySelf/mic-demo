package com.imooc.controller;

import com.imooc.dataobject.Goods;
import com.imooc.dataobject.Inventory;
import com.imooc.dataobject.Order;
import com.imooc.dataobject.User;
import com.imooc.repository.GoodsRepository;
import com.imooc.repository.InventoryRepository;
import com.imooc.repository.OrderRepository;
import com.imooc.repository.UserRepository;
import com.imooc.utils.KeyUtil;
import com.imooc.utils.ResultVOUtil;
import com.imooc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by MySelf on 2018/12/12.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private UserRepository userRepository;

    //下单
    @PostMapping("/order")
    public ResultVO order(@RequestParam("id") Integer id,@RequestParam("goodsId") String goodsId, @RequestParam("num") Integer num){
        User user = userRepository.getOne(id);
        if(user == null){
            return ResultVOUtil.error(444,"用户不存在");
        }
        Goods goods = goodsRepository.getOne(goodsId);
        if(goods == null){
            return ResultVOUtil.error(445,"商品不存在");
        }
        Inventory inventory = inventoryRepository.findByGoodsId(goodsId);
        if ((inventory.getInventoryNum() - num) < 0){
            return ResultVOUtil.error(446,"库存不足");
        }
        BigDecimal sum = goods.getGoodsPrice().multiply(new BigDecimal(num));
        //减库存
        inventory.setInventoryNum(inventory.getInventoryNum()-num);
        inventoryRepository.save(inventory);
        //下单
        Order order = new Order(KeyUtil.getMobookKey(6),goodsId,user.getName(),sum,num,new Date());
        Order orderResult = orderRepository.save(order);
        return ResultVOUtil.success(orderResult.getOrderId());
    }

    //查询订单

}
