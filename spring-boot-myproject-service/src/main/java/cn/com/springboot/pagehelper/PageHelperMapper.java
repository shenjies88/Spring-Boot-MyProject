package cn.com.springboot.pagehelper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/11-20:58
 */
@Mapper
public interface PageHelperMapper {

    List<PageHelperDo> getListFrom();

    List<PageHelperDo> selectByPageNumSize(
            @Param("pageNum") int pageNum,
            @Param("pageSize") int pageSiz);
}
