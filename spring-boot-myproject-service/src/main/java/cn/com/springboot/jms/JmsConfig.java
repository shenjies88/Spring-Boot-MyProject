package cn.com.springboot.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

//@EnableJms
//@Configuration
public class JmsConfig {

    @Bean
    public Queue loggingQueue() {
        return new ActiveMQQueue("logging.queue");
    }
}
