package pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author MaoLG
 * @Date 2018/12/7  14:26
 */
@Data
@TableName("t_goods")
public class Goods implements Serializable{

    private Integer id;

    private String name;
}
