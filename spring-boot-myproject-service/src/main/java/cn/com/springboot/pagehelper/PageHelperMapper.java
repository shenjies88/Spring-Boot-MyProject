package cn.com.springboot.pagehelper;

import cn.com.springboot.vo.PageVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:58
 */
@Mapper
public interface PageHelperMapper {

    List<PageHelperDo> getListFrom(PageVo pageVo);
}
