package cn.cooplan.order.feign;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.Goods;

/**
 * 订单使用, 用来feign调用goods服务
 * @Author MaoLG
 * @Date 2018/12/8  10:53
 */
@FeignClient("goods")  //请求Eureka中的服务中goods服务
public interface GoodsFeignClient {

    //该请求方式只支持 RESTful请求方式
    @RequestMapping("/goods/getGoodsById/{goodsId}")  //采用springmvc的注解,减少学习成本
    //@RequestLine("/goods/getGoodsById/{goodsId}")//Feign自己的注解与@RequestMapping效果一样
    public Goods getGoodsById(@RequestParam("goodsId") Integer goodsId);

}
