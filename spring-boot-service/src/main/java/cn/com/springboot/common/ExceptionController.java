package cn.com.springboot.common;

import cn.com.springboot.vo.HttpResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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
    public HttpResultVO<Void> handIllegalArgumentException(IllegalArgumentException e) {
        return HttpResultVO.fail(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResultVO<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("校验异常", e);
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder("参数校验失败: ");
        bindingResult.getFieldErrors().forEach(fieldError -> errorMessage.append(fieldError.getDefaultMessage()).append(" "));
        return HttpResultVO.fail(errorMessage.toString());
    }

    @ExceptionHandler(Exception.class)
    public HttpResultVO<Void> exceptionHandler(Exception e) {
        log.error("通用异常", e);
        return HttpResultVO.fail("服务器繁忙");
    }
}
