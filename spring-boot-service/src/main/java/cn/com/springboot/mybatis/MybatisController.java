package cn.com.springboot.mybatis;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Mybatis模板")
@AllArgsConstructor
@RequestMapping("/mybatis")
@RestController
public class MybatisController {

    private MybatisService mybatisService;

    @ApiOperation("返回列表")
    @GetMapping("/list")
    public HttpResult list() {
        List<MybatisEntity> mybatisEntityList = mybatisService.listEntity();
        return HttpResult.success(mybatisEntityList);
    }

    @ApiOperation("返回对象")
    @GetMapping("/query")
    public HttpResult query(@RequestParam(name = "code") String code) {
        var mybatisEntity = mybatisService.queryByCode(code);
        return HttpResult.success(mybatisEntity);
    }


}
