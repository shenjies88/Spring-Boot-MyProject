package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @author sj
 * @date 2018/10/27
 */
@Api(tags = "过滤器模板")
@Slf4j
@RequestMapping("/filter")
@RestController
public class FilterController {

    @PostMapping("/doPost")
    public HttpResult doPost(@RequestParam(name = "name", required = false) String name) {
        log.info("Controller:" + name);
        return HttpResult.success();
    }

    @GetMapping("/doGet")
    public HttpResult doGet() {

        return HttpResult.success();
    }
}
