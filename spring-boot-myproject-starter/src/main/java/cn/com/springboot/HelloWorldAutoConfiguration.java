package cn.com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenjies88
 * @since 2019-05-09-14:42
 */
@EnableConfigurationProperties(HelloWorldProperties.class)
@ConditionalOnProperty(prefix = "hello-world", value = "enabled")
@ConditionalOnClass(HelloWorld.class)
@Configuration
public class HelloWorldAutoConfiguration {

    @Autowired
    private HelloWorldProperties helloWorldProperties;

    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld(helloWorldProperties);
    }
}
