package cn.com.springboot.cron;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 定时任务
 */
@Slf4j
@Component
public class GaussianNag {

    @Scheduled(fixedDelay = 5000)
    public void nag() throws InterruptedException {
        var s = String.valueOf(ThreadLocalRandom.current().nextGaussian());
        log.info(s);
        Thread.sleep(1000);
    }
}
