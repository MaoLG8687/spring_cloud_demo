package cn.cooplan.order.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Goods;

/**
 * 订单使用, 用来feign调用goods服务
 * @Author MaoLG
 * @Date 2018/12/8  10:53
 */
@FeignClient("goods")  //请求Eureka中的服务中goods服务
public interface GoodsFeignClient {

    //该请求方式只支持 RESTful请求方式
    @RequestMapping("/goods/getGoodsById/{goodsId}")
    public Goods getGoodsById(@PathVariable("goodsId") Integer goodsId);

}
