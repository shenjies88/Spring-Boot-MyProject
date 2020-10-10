package cn.com.springboot.controller;

import cn.com.springboot.vo.HttpResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * 例子boot
 *
 * @author shenjies88
 * @since 2019-07-26-17:34
 */

@Api(tags = "Boot")
@RestController
@RequestMapping("/boot")
public class BootController {

    @ApiOperation("Boot")
    @GetMapping
    public HttpResult<String> boot() {
        return HttpResult.success("boot");
    }

    @ApiOperation("webClient")
    @GetMapping("/web-client")
    public HttpResult<String> webClient() {
        WebClient client = WebClient.create("http://127.0.0.1:8080");
        return client.get()
                .uri("/boot")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<HttpResult<String>>() {
                })
                .block();
    }
}
