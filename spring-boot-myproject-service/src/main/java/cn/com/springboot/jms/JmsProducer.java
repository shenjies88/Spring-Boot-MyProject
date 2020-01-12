package cn.com.springboot.jms;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Slf4j
@AllArgsConstructor
@Component
public class JmsProducer {

    private JmsMessagingTemplate jmsMessagingTemplate;

    private Queue queue;

    public void send(String message) {
        log.info("Produce: {}", message);
        this.jmsMessagingTemplate.convertAndSend(this.queue, message);
    }
}
