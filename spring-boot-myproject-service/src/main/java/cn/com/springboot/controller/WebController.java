package cn.com.springboot.controller;

import cn.com.springboot.common.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 * @since 2019-04-18-11:35
 */
@Api(tags = "学习前端")
@RequestMapping("/web")
@RestController
public class WebController {

    @ApiOperation("Boot")
    @GetMapping("/boot")
    public HttpResult boot() {
        return HttpResult.success("boot");
    }
}
