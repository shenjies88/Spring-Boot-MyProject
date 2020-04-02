package cn.com.springboot.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author shenjies88
 */
@Slf4j
@Component
public class JmsConsumer {

    @JmsListener(destination = "logging.queue")
    public void consume(@Payload String message) {
        log.info("Consume: {}", message);
    }
}
