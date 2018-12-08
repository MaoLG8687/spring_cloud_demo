package cn.cooplan.goods.service.impl;

import cn.cooplan.goods.service.GoodsService;
import dao.GoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Goods;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:32
 */
@Service
@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsDao.selectById(goodsId);
    }
}
