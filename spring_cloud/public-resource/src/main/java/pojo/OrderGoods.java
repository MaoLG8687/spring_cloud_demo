package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:28
 */
@Data
@TableName("t_order_goods")
public class OrderGoods implements Serializable{

    private Integer id;

    private Integer orderId;

    private Integer goodsId;
}
