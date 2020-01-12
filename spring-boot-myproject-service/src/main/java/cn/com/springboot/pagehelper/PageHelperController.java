package cn.com.springboot.pagehelper;

import cn.com.springboot.HttpResult;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:55
 */
@Slf4j
@Api(tags = "需要去掉注释-PageHelper")
@AllArgsConstructor
@RestController
@RequestMapping("/pagehelper")
public class PageHelperController {

    private PageHelperMapper pageHelperMapper;

    @ApiOperation("实践")
    @GetMapping
    public HttpResult pagehelper() {

//        推荐方式

        log.info("startPage方式");
        PageHelper.startPage(1, 10);
        List<PageHelperDo> list = pageHelperMapper.getListFrom();


        log.info("offsetPage方式");
        PageHelper.offsetPage(1, 10);
        List<PageHelperDo> list1 = pageHelperMapper.getListFrom();

        log.info("selectByPageNumSize方式");
        List<PageHelperDo> list2 = pageHelperMapper.selectByPageNumSize(1, 10);

        return HttpResult.success();
    }
}
