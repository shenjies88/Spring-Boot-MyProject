package cn.com.springboot.controller;

import cn.com.springboot.entity.PageHelperDo;
import cn.com.springboot.mapper.PageHelperMapper;
import cn.com.springboot.utils.PageUtils;
import cn.com.springboot.vo.HttpResultVO;
import cn.com.springboot.vo.PageReqVO;
import cn.com.springboot.vo.PageResultVO;
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
    public HttpResultVO<PageResultVO<PageHelperDo>> pagehelper(@RequestBody @Validated PageReqVO pageVo) {
        return HttpResultVO.success(PageUtils.paging(pageVo, pageHelperMapper::getList));
    }
}
