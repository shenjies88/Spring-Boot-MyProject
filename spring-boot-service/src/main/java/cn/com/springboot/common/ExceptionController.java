package cn.com.springboot.common;

import cn.com.springboot.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author shenjies88
 */
@ResponseStatus(HttpStatus.OK)
@Slf4j
@RestControllerAdvice("cn.com.springboot")
public class ExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public HttpResult handIllegalArgumentException(IllegalArgumentException e) {
        log.error("业务异常:", e);
        return HttpResult.fail(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("校验异常", e);
        var bindingResult = e.getBindingResult();
        var errorMessage = new StringBuilder("参数校验失败: ");
        bindingResult.getFieldErrors().forEach(fieldError -> errorMessage.append(fieldError.getDefaultMessage()).append(" "));
        return HttpResult.fail(errorMessage.toString());
    }

    @ExceptionHandler(Exception.class)
    public HttpResult<String> exceptionHandler(Exception e) {
        log.error("通用异常", e);
        return HttpResult.fail("服务器繁忙");
    }
}
