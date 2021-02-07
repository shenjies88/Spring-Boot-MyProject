package cn.com.springboot.controller;

import cn.com.springboot.entity.MybatisDo;
import cn.com.springboot.service.MybatisService;
import cn.com.springboot.vo.HttpResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjies88
 */
@Api(tags = "Mybatis")
@AllArgsConstructor
@RequestMapping("/mybatis")
@RestController
public class MybatisController {

    private final MybatisService mybatisService;

    @ApiOperation("返回列表")
    @GetMapping("/list")
    public HttpResultVO<List<MybatisDo>> list() {
        List<MybatisDo> mybatisDoList = mybatisService.listEntity();
        return HttpResultVO.success(mybatisDoList);
    }

    @ApiOperation("返回对象")
    @GetMapping("/query")
    public HttpResultVO<MybatisDo> query(@RequestParam(name = "code") String code) {
        MybatisDo mybatisEntity = mybatisService.queryByCode(code);
        return HttpResultVO.success(mybatisEntity);
    }


}
