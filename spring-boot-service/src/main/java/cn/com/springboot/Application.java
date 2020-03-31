package cn.com.springboot;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@MapperScan("cn.com.springboot.mapper")
@SpringBootApplication
public class Application {

    private static HelloWorld helloWorld;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        if (helloWorld != null) {
            log.info("");
            log.info("自动配置成功");
            log.info("name {}", helloWorld.getHelloWorldProperties().getName());
            log.info("sex {}", helloWorld.getHelloWorldProperties().getSex());
            log.info("age {}", helloWorld.getHelloWorldProperties().getAge());
            log.info("enabled {}", helloWorld.getHelloWorldProperties().getEnabled());
        }
    }

    @Autowired
    public void setHelloWorld(HelloWorld helloWorld) {
        Application.helloWorld = helloWorld;
    }

}
