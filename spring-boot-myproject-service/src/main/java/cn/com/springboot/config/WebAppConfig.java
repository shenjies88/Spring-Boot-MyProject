package cn.com.springboot.config;

import cn.com.springboot.common.MyIntercept;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * Web配置
 */
@AllArgsConstructor
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    private MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * includes是拦截的路径
         * exclude是不拦截的路径
         * 利用正则表达式灵活处理
         */
        String[] includes = new String[]{"/mybatis/**"};
        String[] exclude = new String[]{};
        var mappedInterceptor = new MappedInterceptor(includes, exclude, myIntercept);
        registry.addInterceptor(mappedInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/websocket/**")
                .addResourceLocations("classpath:/static/websocket/");
    }


}
