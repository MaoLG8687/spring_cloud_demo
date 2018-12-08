package cn.cooplan.order.service.impl;

import cn.cooplan.order.service.OrderService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dao.OrderDao;
import dao.OrderGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import pojo.Goods;
import pojo.Order;
import pojo.OrderGoods;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:03
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private OrderGoodsDao orderGoodsDao;

    @Override
    public List<Order> getAllOrder() {
//        List<Order> orders = orderDao.selectList(null);
        List<Order> orders = orderDao.selectAll();
        return orders;
    }


    //使用负载均衡ribbon写法, 默认
    @Override
    public List<Goods> getOrderInGoods(Integer orderId) {
        OrderGoods o = new OrderGoods();
        o.setOrderId(orderId);
        QueryWrapper queryWrapper = new QueryWrapper(o);
        List<OrderGoods> ogs = orderGoodsDao.selectList(queryWrapper);
        List<Goods> goodses = new ArrayList<>();
        String serviceId = "GOODS";
        for (OrderGoods orderGoods : ogs) {
            String url = "http://" + serviceId + "/goods/getGoodsById?goodsId=" + orderGoods.getGoodsId();
            Goods goods = restTemplate.getForObject(url, Goods.class);
            goodses.add(goods);
        }

        return goodses;
    }

    //未添加负载均衡ribbon写法
//    @Override
//    public List<Goods> getOrderInGoods(Integer orderId) {
//        OrderGoods o = new OrderGoods();
//
//        o.setOrderId(orderId);
//        QueryWrapper queryWrapper = new QueryWrapper(o);
//        List<OrderGoods> ogs = orderGoodsDao.selectList(queryWrapper);
//        String serviceId = "goods";
//        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
//        ServiceInstance serviceInstance = instances.get(0);
//        String host = serviceInstance.getHost();
//        int port = serviceInstance.getPort();
//        List<Goods> goodses = new ArrayList<>();
//        for (OrderGoods orderGoods : ogs) {
//            String url = "http://" + host + ":" + port + "/goods/getGoodsById?goodsId=" + orderGoods.getGoodsId();
//            Goods goods = restTemplate.getForObject(url, Goods.class);
//            goodses.add(goods);
//        }
//        return goodses;
//    }


}
