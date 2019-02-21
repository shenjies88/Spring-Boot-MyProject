package cn.com.springboot.controller;

import cn.com.springboot.service.MailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "发送邮件消息队列")
@AllArgsConstructor
@RequestMapping("/mail")
@RestController
public class MailController {

    private MailService mailService;

    @ApiOperation("发送邮件")
    @PostMapping
    public void testSimpleMail() {
        mailService.sendSimpleMail("1961486254@qq.com", "test simple mail", " hello this is simple mail");
    }
}
