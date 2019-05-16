package cn.com.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于封装分页信息
 *
 * @author shenjies88
 * @since 2019-02-22-08:46
 */
@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page<T> {
    private T list;
    private Integer pageSize;
    private Integer pageIndex;
    private Integer pageNum;
    private Integer count;

    /**
     * 未分页的调用
     */
    public static <T> Page pageFormat(List<T> list, Integer pageSize, Integer pageIndex) {

        Integer count = list.size();

        Integer pageNum = (count + pageSize - 1) / pageSize;

        if (pageIndex > pageNum) {
            return new Page(new ArrayList<>(), 1, 1, 1, 0);
        }

        Integer offset = (pageIndex - 1) * pageSize;

//      pageIndex 等于1 并且 pageSize <= List.size，可以截取
        if (pageIndex == 1 && pageSize <= count) {
            list = list.subList(0, pageSize);

//      pageIndex 大于1 并且 offset + pageSize <= list.size， 可以截取
        } else if (pageIndex > 1 && offset + pageSize <= count) {
            list = list.subList(offset, offset + pageSize);

//      pageIndex 大于1 并且 offset + pageSize > list.size，可以截取
        } else if (offset > 1 && offset + pageSize > count) {
            list = list.subList(offset, list.size());
        }

        return new Page(list, pageSize, pageIndex, pageNum, count);
    }

    /**
     * 已经分好页的调用
     */
    public static <T> Page pageFormat(List<T> list, Integer pageSize, Integer pageIndex, Integer count) {
        Integer pageNum = (count + pageSize - 1) / pageSize;

        if (pageIndex > pageNum) {
            return new Page(new ArrayList<>(), 1, 1, 1, 0);
        }
        return new Page(list, pageSize, pageIndex, pageNum, count);
    }

}
