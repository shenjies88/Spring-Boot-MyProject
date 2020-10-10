package cn.com.springboot.utils;

import cn.com.springboot.vo.PageResultVo;
import cn.com.springboot.vo.PageVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;

import java.util.List;
import java.util.function.Function;

/**
 * @author shenjies88
 * @since 2020/1/12-12:53
 */
public interface PageUtils {

    static <T extends PageVo, R> PageResultVo<R> paging(T requestParam, Function<T, List<R>> function) {
        Integer pageNum = requestParam.getPageNum();
        Integer pageSize = requestParam.getPageSize();
        Page<R> page = PageMethod.startPage(pageNum, pageSize);
        function.apply(requestParam);
        return PageResultVo.format(page.getResult(), page.getTotal(), pageNum, pageSize);
    }
}
