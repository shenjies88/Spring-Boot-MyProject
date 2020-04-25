package cn.com.springboot.common.aop;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@Aspect
@Slf4j
public class ApiAspect {

    /**
     * 切面
     */
    private final String pointCut = "execution(* cn.com.springboot.controller..*.*(..))";

    @Pointcut(pointCut)
    private void pointcut() {
    }


    @Before(value = pointCut)
    public void before(JoinPoint joinPoint) {
        //获取类名、方法
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        //拼接日志内容
        StringBuilder messageBuf = new StringBuilder();
        System.out.println("====================  请求开始  ==================");
        messageBuf.append(className);
        messageBuf.append("\r\n接口名称").append(methodName);
        messageBuf.append("\r\n请求参数: ");
        Object[] params = joinPoint.getArgs();
        for (Object param : params) {
            if (!StringUtils.isEmpty(param.toString())) {
                messageBuf.append(param);
            }
        }

        String message = messageBuf.toString();
        message = message.replaceAll("\\\\n", "\n").replaceAll("\\\\r", "\r");

        if (StringUtils.isEmpty(message)) {
            message += "无输入参数";
        }
        log.info(message);

    }

    @AfterReturning(value = "pointcut()", returning = "returnObj")
    public void afterReturn(Object returnObj) {
        String message = "";
        //去掉空格、回车
        if (returnObj == null) {
            message = "\n无返回参数\n";
        } else {
            message = "\n返回参数:\n" + JSON.toJSONString(returnObj).replaceAll("\\\\n", "\n").replaceAll("\\\\r", "\r");
        }

        log.info(message);
        System.out.println("====================  请求结束  ==================");
        System.out.println();
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        StringBuilder message = new StringBuilder();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            log.error(" \n接口异常：" + message + e.getMessage(), e);
            throw e;
        }
        Long end = System.currentTimeMillis();
        message.append(" 执行时间: [").append(end - begin).append("]ms");
        log.info(message.toString());
        return result;
    }
}