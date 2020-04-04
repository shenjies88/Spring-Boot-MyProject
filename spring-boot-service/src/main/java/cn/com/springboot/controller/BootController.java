package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 例子boot
 *
 * @author shenjies88
 * @since 2019-07-26-17:34
 */

@Api(tags = "Boot")
@RestController
@RequestMapping("/boot")
public class BootController {

    @ApiOperation("Boot")
    @GetMapping
    public HttpResult<String> boot() {
        return HttpResult.success("boot");
    }
}
