package cn.com.springboot.common.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author shenjies88
 */
@Slf4j
@Aspect
@Component
public class LoggerAdvice {

    private static final int PARAM_LENGTH = 1024;


    @Before("within(cn.com.springboot..*) && @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        log.info("执行 " + loggerManage.description() + " 开始");
    }

    @AfterReturning("within(cn.com.springboot..*) && @annotation(loggerManage)")
    public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        log.info("执行 " + loggerManage.description() + " 结束");
    }

    @AfterThrowing(pointcut = "within(cn.com.springboot..*) && @annotation(loggerManage)", throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception ex) {
        log.error("执行 " + loggerManage.description() + " 异常", ex);
    }

    private String parseParams(Object[] parames) {
        if (null == parames || parames.length <= 0 || parames.length > PARAM_LENGTH) {
            return "无参数";
        }
        StringBuffer param = new StringBuffer("传入参数[{}] ");
        for (Object obj : parames) {
            param.append(obj).append("  ");
        }
        return param.toString();
    }

}
