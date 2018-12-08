package dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import pojo.Order;

import java.util.List;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:04
 */
public interface OrderDao extends BaseMapper<Order>{

    List<Order> selectAll();

}
