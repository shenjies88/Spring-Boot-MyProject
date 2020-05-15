package cn.com.springboot.mapper;

import cn.com.springboot.entity.GoodsDo;
import org.apache.ibatis.annotations.Param;

/**
 * @author shenjies88
 * @since 2020/5/12-8:10 PM
 */
public interface GoodsMapper {

    /**
     * 排他锁查询
     *
     * @param id 商品id
     * @return 商品实体
     */
    GoodsDo lock(@Param("id") Integer id);

    /**
     * 根据商品名查询商品
     *
     * @param name 商品名
     * @return 商品实体
     */
    GoodsDo selectByName(@Param("name") String name);

    /**
     * 乐观锁秒杀
     *
     * @param id  商品id
     * @param num 当前商品数量
     * @return 更新条数
     */
    int optimismSpikeGoods(@Param("id") Integer id, @Param("num") Integer num);

    /**
     * 悲观锁秒杀
     *
     * @param id 商品id
     */
    void pessimisticSpikeGoods(@Param("id") Integer id);
}
