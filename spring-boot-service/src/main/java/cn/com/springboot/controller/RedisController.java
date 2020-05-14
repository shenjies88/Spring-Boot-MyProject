package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author shenjies88
 * @since 2020/5/14-4:34 PM
 */
@Slf4j
@Api(tags = "Redis")
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedissonClient redisson;

    @ApiOperation("Redis Lock")
    @GetMapping("/lock")
    public HttpResult<String> lock() {
        RLock lock = redisson.getLock("myLock");
        try {
            boolean res = lock.tryLock(10, 4, TimeUnit.SECONDS);
            return res ? HttpResult.success("抢到锁了") : HttpResult.fail("没抢到锁");
        } catch (Exception e) {
        }
        return HttpResult.success("Lock");
    }
}
