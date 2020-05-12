package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import cn.com.springboot.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 * @since 2020/5/12-8:04 PM
 */
@Api(tags = "商品秒杀")
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("乐观锁秒杀")
    @GetMapping("/optimism-spike-goods")
    public HttpResult<Integer> optimismSpikeGoods(@ApiParam("商品名") @RequestParam String name) {
        Integer total = goodsService.optimismSpikeGoods(name);
        return HttpResult.success(total);
    }
}
