package cn.cooplan.goods.controller;

import cn.cooplan.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:33
 */
@RestController
@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("getGoodsById/{goodsId}")
    Object getGoodsById(@PathVariable("goodsId") Integer goodsId){
        return goodsService.getGoodsById(goodsId);
    }
}
