package cn.com.springboot.rabbit;

import cn.com.springboot.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.com.springboot.rabbit.RabbitConfig.TOPIC_EXCHANGE_NAME;

@Api(tags = "Rabbit消息队列")
@Slf4j
//@AllArgsConstructor
@RequestMapping("/rabbit")
@RestController
public class RabbitController {

    private RabbitTemplate rabbitTemplate;

    @ApiOperation("两个队列都能接受")
    @PostMapping("/sendAll")
    public HttpResult sendAll() {
        var content = "spring.boot.b";
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "spring.boot.b", content);
        log.info(content);
        return HttpResult.success("AB队列都接受");
    }

    @ApiOperation("只有A队列接受")
    @PostMapping("/sendA")
    public HttpResult sendA() {
        var content = "spring.boot.c";
        log.info(content);
        this.rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, "spring.boot.A", content);
        return HttpResult.success("只有A队列接受");
    }
}
