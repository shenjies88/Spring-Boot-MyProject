package cn.com.springboot.utils;

import cn.com.springboot.vo.PageResultVo;
import cn.com.springboot.vo.PageVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;
import java.util.function.Function;

/**
 * @author shenjies88
 * @since 2020/1/12-12:53
 */
public class PageUtils {

    public static <T extends PageVo, R> PageResultVo paging(T requestParm, Function<T, List<R>> function) {
        Integer pageNum = requestParm.getPageNum();
        Integer pageSize = requestParm.getPageSize();
        Page<R> page = PageHelper.startPage(pageNum, pageSize);
        function.apply(requestParm);
        return PageResultVo.format(page.getResult(), page.getTotal(), pageNum, pageSize);
    }
}
