package cn.com.springboot.mapper;

import cn.com.springboot.entity.PageHelperDo;
import cn.com.springboot.vo.PageVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:58
 */
@Repository
public interface PageHelperMapper {

    /**
     * 获取实体分页
     *
     * @param pageVo 分页请求
     * @return 实体列表
     */
    List<PageHelperDo> getList(PageVO pageVo);
}
