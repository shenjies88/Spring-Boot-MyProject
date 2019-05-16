package cn.com.springboot.config;

import cn.com.springboot.common.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器配置
 *
 * @author sj
 * @date 2018/10/27
 */
@SuppressWarnings("unchecked")
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter() {
        var registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
//        拦截路径
        registration.addUrlPatterns("/filter/doPost");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

}
