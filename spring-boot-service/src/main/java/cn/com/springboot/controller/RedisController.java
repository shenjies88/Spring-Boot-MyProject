package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
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

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    @ApiOperation("Test Lua")
    @GetMapping("/test-lua")
    public HttpResult testLua() {
        DefaultRedisScript<Long> script = new DefaultRedisScript();
        script.setResultType(Long.class);
        script.setScriptSource(new ResourceScriptSource(new
                ClassPathResource("limite.lua")));
        redisTemplate.opsForValue().set("123", 1);
        Long limite = redisTemplate.execute(script, Collections.singletonList("limite"), 10, 20);
        return limite == 1 ? HttpResult.success("没被限流") : HttpResult.fail("被限流了");
    }
}
