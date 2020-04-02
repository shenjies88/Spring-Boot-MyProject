package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import cn.com.springboot.jms.JmsProducer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shenjies88
 */
@Api(tags = "JMS消息队列")
@AllArgsConstructor
@RequestMapping("/jms")
@RestController
public class JmsController {

    private JmsProducer jmsProducer;

    @ApiOperation("JMS消息")
    @PostMapping("/send")
    public HttpResult<String> jmsMessage(@RequestParam(name = "websocket", required = false) String message) {
        var msg = message;
        if (msg == null) {
            msg = "默认消息";
        }
        this.jmsProducer.send(msg);
        return HttpResult.success(msg);
    }
}