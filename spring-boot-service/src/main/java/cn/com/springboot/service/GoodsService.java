package cn.com.springboot.service;

/**
 * @author shenjies88
 * @since 2020/5/12-8:06 PM
 */

import cn.com.springboot.entity.GoodsDo;
import cn.com.springboot.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 乐观锁秒杀
     */
    @Transactional(rollbackFor = Exception.class)
    public Integer optimismSpikeGoods(String name) {
        GoodsDo goodsDo = goodsMapper.selectByName(name);
        if (goodsDo.getNum().equals(0)) {
            throw new RuntimeException("商品已经卖完了");
        }
        int result = goodsMapper.optimismSpikeGoods(goodsDo.getId(), goodsDo.getNum());
        if (result != 1) {
            throw new RuntimeException("没抢到商品");
        }
        return goodsDo.getNum() - 1;
    }
}
