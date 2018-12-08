package cn.cooplan.order.controller;

import cn.cooplan.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:00
 */
@RestController
@RequestMapping("/order/")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("getAll")
    public Object getAll(){
        return  orderService.getAllOrder();
    }

    @RequestMapping("getOrderInGoods")
    public Object getOrderInGoods(Integer orderId){
        return orderService.getOrderInGoods(orderId);
    }
}
