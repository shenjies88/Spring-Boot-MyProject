package cn.com.springboot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 两种实现
 */
@Mapper
public interface MybatisMapper {

    List<MybatisEntity> getListEntity(@Param("offset") Integer offset,
                                      @Param("limit") Integer limit);

    @Select("SELECT" +
            "  s.student_code AS studentCode ," +
            "  s.name AS name ," +
            "  s.age AS age," +
            "  s.sex AS sex," +
            "  a.sports AS sports ," +
            "  a.student_organization AS studentOrganization," +
            "  a.course AS course" +
            "  FROM student s LEFT JOIN activity a ON s.student_code = a.activity_student_code" +
            "  WHERE s.student_code = #{code}")
    MybatisEntity queryByCode(@Param("code") String code);
}
