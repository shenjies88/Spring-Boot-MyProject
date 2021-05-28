package cn.com.springboot.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author shenjies88
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultVO<T> {

    @ApiModelProperty("总数")
    private Long count;

    @ApiModelProperty("页标")
    private Integer pageNum;

    @ApiModelProperty("分页数")
    private Integer pageSize;

    @ApiModelProperty("数据集合")
    private List<T> list;

    @SuppressWarnings("unchecked")
    public static <T> PageResultVO<T> format(List<T> list, Long count, Integer pageNum, Integer pageSize) {
        return new PageResultVO(count, pageNum, pageSize, list);
    }
}