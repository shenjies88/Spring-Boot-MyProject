package cn.com.springboot.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * @author shenjies88
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageReqVO {

    @Min(1)
    @ApiModelProperty(value = "页标", example = "1")
    private Integer pageNum;

    @Min(1)
    @ApiModelProperty(value = "分页数", example = "10")
    private Integer pageSize;
}