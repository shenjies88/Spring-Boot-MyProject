package cn.com.springboot.mapper;

import cn.com.springboot.entity.PageHelperDo;
import cn.com.springboot.vo.PageVo;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:58
 */
public interface PageHelperMapper {

    /**
     * 获取实体分页
     *
     * @param pageVo 分页请求
     * @return 实体列表
     */
    List<PageHelperDo> getList(PageVo pageVo);
}
