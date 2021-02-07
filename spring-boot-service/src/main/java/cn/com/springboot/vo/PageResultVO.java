package cn.com.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author shenjies88
 * @since 2020/1/12-12:38
 */
@Data
@AllArgsConstructor
public class PageResultVO<T> {

    private Long count;

    private Integer pageNum;

    private Integer pageSize;

    private List<T> list;

    @SuppressWarnings("unchecked")
    public static <T> PageResultVO<T> format(List<T> list, Long count, Integer pageNum, Integer pageSize) {
        return new PageResultVO(count, pageNum, pageSize, list);
    }
}
