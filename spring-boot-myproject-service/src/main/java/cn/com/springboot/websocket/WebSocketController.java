package cn.com.springboot.websocket;

import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

@Api(tags = "WebSocket模板")
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
