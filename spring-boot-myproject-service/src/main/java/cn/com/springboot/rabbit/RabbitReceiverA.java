package cn.com.springboot.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
//@RabbitListener(queues = "spring-boot-A")
@Component
public class RabbitReceiverA {

    //    @RabbitHandler
    public void receiveMessage(String message) {
        log.info("ReceivedA <" + message + ">");

    }

}
