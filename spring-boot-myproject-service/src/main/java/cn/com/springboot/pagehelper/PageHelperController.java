package cn.com.springboot.pagehelper;

import cn.com.springboot.HttpResult;
import cn.com.springboot.utils.PageUtils;
import cn.com.springboot.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 * @since 2020/1/11-20:55
 */
@Api(tags = "需要去掉注释-PageHelper")
@RestController
@RequestMapping("/pagehelper")
public class PageHelperController {

    @Autowired
    private PageHelperMapper pageHelperMapper;

    @ApiOperation("实践")
    @GetMapping
    public HttpResult pagehelper() {
        return HttpResult.success(PageUtils.paging(new PageVo(2, 10), pageHelperMapper::getListFrom));
    }
}
