package cn.com.springboot.utils;

import cn.com.springboot.vo.PageReqVO;
import cn.com.springboot.vo.PageResultVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;

import java.util.List;
import java.util.function.Function;

/**
 * @author shenjies88
 */
public interface PageUtils {

    static <T extends PageReqVO, R> PageResultVO<R> paging(T requestParam, Function<T, List<R>> function) {
        Integer pageNum = requestParam.getPageNum();
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        Integer pageSize = requestParam.getPageSize();
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        Page<R> page = PageMethod.startPage(pageNum, pageSize);
        function.apply(requestParam);
        return PageResultVO.format(page.getResult(), page.getTotal(), pageNum, pageSize);
    }
}