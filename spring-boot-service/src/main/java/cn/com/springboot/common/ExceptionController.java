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
    public HttpResult<String> exceptionHandler(Exception e) {
        log.error("通用错误处理", e);
        return HttpResult.fail("服务器繁忙");
    }
}
