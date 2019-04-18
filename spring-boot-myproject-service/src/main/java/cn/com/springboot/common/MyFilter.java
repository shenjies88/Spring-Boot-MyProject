package cn.com.springboot.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 实现自己的request 过滤器
 *
 * @author sj
 * @date 2018/10/27
 */
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var parameterRequestWrapper = new ParameterRequestWrapper((HttpServletRequest) servletRequest);
        if (StringUtils.isEmpty(parameterRequestWrapper.getParameter("name"))) {
            parameterRequestWrapper.addParameter("name", "我是过滤器增加的url参数");
            log.info("过滤器设值");
        }
        filterChain.doFilter(parameterRequestWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
