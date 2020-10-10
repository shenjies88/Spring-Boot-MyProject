package cn.com.springboot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shenjies88
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResult<T> {

    /**
     * 状态码，0正常，1异常
     */
    private int code;

    /**
     * 状态
     */
    private boolean status;

    /**
     * 信息
     */
    private String message;

    /**
     * 具体数据
     */
    private T data;

    public static HttpResult<Void> success() {
        return new HttpResult<>(0, true, "success", null);
    }

    public static <U> HttpResult<U> success(U data) {
        return new HttpResult<>(0, true, "success", data);
    }

    public static HttpResult<Void> fail(String message) {
        return new HttpResult<>(1, false, message, null);
    }
}
