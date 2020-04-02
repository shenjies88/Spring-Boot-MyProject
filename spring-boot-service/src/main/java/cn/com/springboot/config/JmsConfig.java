package cn.com.springboot.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

/**
 * @author shenjies88
 */
@EnableJms
@Configuration
public class JmsConfig {

    @Bean
    public Queue loggingQueue() {
        return new ActiveMQQueue("logging.queue");
    }
}
