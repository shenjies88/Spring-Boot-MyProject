package cn.com.springboot.controller;

import cn.com.springboot.websocket.WSReceiverMessage;
import cn.com.springboot.websocket.WSReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Api(tags = "WebSocket")
@RequestMapping("/websocket")
@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public WSReturnMessage greeting(WSReceiverMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new WSReturnMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/ws")
    public String webScoket() {
        return "ws";
    }
}
