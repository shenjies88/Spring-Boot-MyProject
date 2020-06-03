//package cn.com.springboot.controller;
//
//import cn.com.springboot.vo.HttpResult;
//import io.swagger.annotations.Api;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author shenjies88
// * @since 2020/6/3-5:49 PM
// */
//@Slf4j
//@Api(tags = "Kafka")
//@RequestMapping("/kafka")
//@RestController
//public class KafkaController {
//
//    @Autowired
//    private KafkaTemplate<Object, Object> template;
//
//    @GetMapping("/send/{input}")
//    public HttpResult sendFoo(@PathVariable String input) {
//        this.template.send("topic_input", input);
//        return HttpResult.success();
//    }
//    @KafkaListener(id = "myGroup", topics = "topic_input",groupId = "1")
//    public void listen(String input) {
//        log.info("input value: {}" , input);
//    }
//}
