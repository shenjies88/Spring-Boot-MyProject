package cn.com.springboot.mapper;

import cn.com.springboot.entity.PageHelperDo;
import cn.com.springboot.vo.PageVo;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:58
 */
public interface PageHelperMapper {

    List<PageHelperDo> getList(PageVo pageVo);
}
