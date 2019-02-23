package cn.com.springboot.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


//@Configuration
public class RabbitConfig {

    public static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";

    public static final String QUEUENAMEA = "spring-boot-A";

    public static final String QUEUENAMEB = "spring-boot-B";

    @Bean
    Queue queueA() {
        return new Queue(QUEUENAMEA);
    }

    @Bean
    Queue queueB() {
        return new Queue(QUEUENAMEB);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(TOPIC_EXCHANGE_NAME);
    }

    @Bean
    Binding bindingA(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with("spring.boot.#");
    }

    @Bean
    Binding bindingB(Queue queueB, TopicExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with("spring.boot.b");
    }

}
