package cn.com.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shenjies88
 * @since 2020/1/12-12:38
 */
@Data
@AllArgsConstructor
public class PageVo {

    PageVo() {

    }

    private Integer pageNum = 1;

    private Integer pageSize = 10;
}
