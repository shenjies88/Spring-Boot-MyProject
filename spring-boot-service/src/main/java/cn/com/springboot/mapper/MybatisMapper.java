package cn.com.springboot.mapper;

import cn.com.springboot.entity.MybatisDo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 两种实现
 *
 * @author shenjies88
 */
@Repository
public interface MybatisMapper {

    /**
     * 获取实体分页 xml实现
     *
     * @param limit  限制
     * @param offset 跳过
     * @return 实体列表
     */
    List<MybatisDo> getPage(@Param("offset") Integer offset,
                            @Param("limit") Integer limit);

    /**
     * 连表查询 注解实现
     *
     * @param code 唯一标识
     * @return 实体
     */
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
    MybatisDo getByCode(@Param("code") String code);
}
