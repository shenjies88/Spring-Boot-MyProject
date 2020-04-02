package cn.com.springboot.controller;

import cn.com.springboot.HttpResult;
import cn.com.springboot.websocket.WsReceiverMessage;
import cn.com.springboot.websocket.WsReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

/**
 * @author shenjies88
 */
@Api(tags = "WebSocket")
@RequestMapping("/websocket")
@Controller
public class WebSocketController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public WsReturnMessage greeting(WsReceiverMessage message) throws Exception {
        Thread.sleep(1000);
        return new WsReturnMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @GetMapping("/ws")
    public HttpResult<String> webSocket() {
        return HttpResult.success("ws");
    }
}
