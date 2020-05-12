package cn.com.springboot.entity;

import lombok.Data;

/**
 * @author shenjies88
 * @since 2020/5/12-8:01 PM
 */
@Data
public class GoodsDo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 数量
     */
    private Integer num;
}
