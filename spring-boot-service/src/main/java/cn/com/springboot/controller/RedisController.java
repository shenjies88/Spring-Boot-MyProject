//package cn.com.springboot.controller;
//
//import cn.com.springboot.vo.HttpResultVO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.scripting.support.ResourceScriptSource;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author shenjies88
// * @since 2020/5/14-4:34 PM
// */
//@Slf4j
//@Api(tags = "Redis")
//@RestController
//@RequestMapping("/redis")
//public class RedisController {
//
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    private RedissonClient redisson;
//
//    @ApiOperation("Redis Lock")
//    @GetMapping("/lock")
//    public HttpResultVO<String> lock() {
//        RLock lock = redisson.getLock("myLock");
//        try {
//            boolean res = lock.tryLock(7, 4, TimeUnit.SECONDS);
//            return res ? HttpResultVO.success("抢到锁了") : HttpResultVO.fail("没抢到锁");
//        } catch (Exception e) {
//            if (lock.isLocked()) {
//                lock.unlock();
//            }
//            log.error(e.toString());
//            return HttpResultVO.fail("出现异常");
//        }
//    }
//
//    @ApiOperation("Test Lua")
//    @GetMapping("/test-lua")
//    public HttpResultVO testLua() {
//        DefaultRedisScript<Long> script = new DefaultRedisScript();
//        script.setResultType(Long.class);
//        script.setScriptSource(new ResourceScriptSource(new
//                ClassPathResource("limite.lua")));
//        Long limite = redisTemplate.execute(script, Collections.singletonList("limite"), 10, 20);
//        return limite == 1 ? HttpResultVO.success("没被限流") : HttpResultVO.fail("被限流了");
//    }
//}
