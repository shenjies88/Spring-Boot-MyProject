package cn.com.springboot.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author shenjies88
 */
@Slf4j
@Configuration
@EnableScheduling
public class GaussianNag {

    @Scheduled(fixedDelay = 5000)
    public void nag() throws InterruptedException {
        var s = String.valueOf(new Date());
        log.info(s);
        Thread.sleep(1000);
    }
}
