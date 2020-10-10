package cn.com.springboot.config;

import cn.com.springboot.common.MyIntercept;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;

/**
 * @author shenjies88
 */
@AllArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] includes = new String[]{"/mybatis/**"};
        String[] exclude = new String[]{};
        MappedInterceptor mappedInterceptor = new MappedInterceptor(includes, exclude, myIntercept);
        registry.addInterceptor(mappedInterceptor);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/websocket/**")
                .addResourceLocations("classpath:/static/websocket/");
    }


}
