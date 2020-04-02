package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import cn.com.springboot.entity.PageHelperDo;
import cn.com.springboot.mapper.PageHelperMapper;
import cn.com.springboot.utils.PageUtils;
import cn.com.springboot.vo.PageResultVo;
import cn.com.springboot.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 * @since 2020/1/11-20:55
 */
@Slf4j
@Api(tags = "PageHelper")
@RestController
@RequestMapping("/pagehelper")
public class PageHelperController {

    @Autowired
    private PageHelperMapper pageHelperMapper;

    @ApiOperation("实践")
    @PostMapping
    public HttpResult<PageResultVo<PageHelperDo>> pagehelper(@RequestBody @Validated PageVo pageVo) {
        return HttpResult.success(PageUtils.paging(pageVo, pageHelperMapper::getList));
    }
}
