package cn.com.springboot.common;

import cn.com.springboot.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 捕获异常
 */
@ResponseStatus(HttpStatus.OK)
@Slf4j
@RestControllerAdvice("cn.com.springboot")
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var className = e.getClass().getSimpleName();
        var bindingResult = e.getBindingResult();
        var errorMessage = new StringBuilder("参数校验失败: ");
        bindingResult.getFieldErrors().forEach(fieldError -> errorMessage.append(fieldError.getDefaultMessage()).append(" "));
        log.error(className, e);
        return HttpResult.fail(errorMessage.toString());
    }

    @ExceptionHandler(Exception.class)
    public HttpResult exceptionHandler(Exception e) {
        var message = e.getMessage();
        if (message == null) {
            message = e.getClass().getSimpleName();
        }
        log.warn(message, e);
        return HttpResult.fail(message);
    }
}
