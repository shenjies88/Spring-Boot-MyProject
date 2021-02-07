package cn.com.springboot.vo;

import com.github.crab2died.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author shenjies88
 * @since 2020/5/21-2:13 PM
 */
@Data
@ApiModel("Excel")
public class ExcelVO {

    /**
     * 学号
     */
    @ExcelField(title = "学号", order = 1)
    private Integer num;

    /**
     * 姓名
     */
    @ExcelField(title = "姓名", order = 2)
    private String name;

    /**
     * 年龄
     */
    @ExcelField(title = "年龄", order = 3)
    private Integer age;
}
