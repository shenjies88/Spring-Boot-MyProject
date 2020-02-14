package cn.com.springboot.mybatis;

import lombok.Data;

/**
 * mybatis的实体类
 * <p>
 * 连表
 */
@Data
public class MybatisEntity {

    /**
     * 学号，唯一标识
     */
    private String studentCode;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private String sex;
    /**
     * 运动
     */
    private String sports;
    /**
     * 社团
     */
    private String studentOrganization;
    /**
     * 课程
     */
    private String course;

}
