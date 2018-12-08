package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:01
 */
@Data
@TableName("t_order")
public class Order implements Serializable{

    private Integer id;

    private String time;

    private Integer num;
}
