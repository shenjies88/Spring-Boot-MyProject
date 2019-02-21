package cn.com.springboot.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 捕获controller层的异常
 */
@Slf4j
@RestControllerAdvice("cn.com.springboot")
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(Exception e) {
        var message = e.getMessage();
        if (message == null) {
            message = e.getClass().getSimpleName();
        }
        log.warn(message, e);
        return new ResponseEntity<>(HttpResult.fail(message), HttpStatus.OK);
    }
}
