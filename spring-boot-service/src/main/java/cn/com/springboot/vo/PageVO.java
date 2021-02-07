package cn.com.springboot.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * @author shenjies88
 * @since 2020/1/12-12:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO {

    @Min(1)
    @ApiModelProperty(example = "1")
    private Integer pageNum = 1;

    @Min(1)
    @ApiModelProperty(example = "10")
    private Integer pageSize = 10;
}
