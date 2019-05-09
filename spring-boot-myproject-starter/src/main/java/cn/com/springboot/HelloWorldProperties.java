package cn.com.springboot;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shenjies88
 * @since 2019-05-09-14:47
 */
@Data
@ConfigurationProperties(prefix = "hello-world")
public class HelloWorldProperties {
    private String name;
    private Integer age;
    private String sex;
}
