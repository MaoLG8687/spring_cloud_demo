package cn.cooplan.order.service;

import pojo.Goods;
import pojo.Order;

import java.util.List;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:00
 */
public interface OrderService {

    List<Order> getAllOrder();

    List<Goods> getOrderInGoods(Integer orderId);
}
