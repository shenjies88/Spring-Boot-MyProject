package cn.com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Slf4j
@EnableSwagger2
@SpringBootApplication
        (exclude = DataSourceAutoConfiguration.class)
public class Application {

    private static HelloWorld helloWorld;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        if (helloWorld.getHelloWorldProperties() != null) {
            log.info("");
            log.info("自动配置成功");
            log.info("name {}", helloWorld.getHelloWorldProperties().getName());
            log.info("sex {}", helloWorld.getHelloWorldProperties().getSex());
            log.info("age {}", helloWorld.getHelloWorldProperties().getAge());
        }
    }

    @Autowired
    public void setHelloWorld(HelloWorld helloWorld) {
        Application.helloWorld = helloWorld;
    }


}
