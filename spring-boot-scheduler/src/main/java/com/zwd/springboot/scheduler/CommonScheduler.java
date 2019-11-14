package com.zwd.springboot.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 随风逐梦
 * @create 2019-11-14 16:26
 */
@Component
@EnableAsync//允许异步执行
public class CommonScheduler {
    private static final Logger log = LoggerFactory.getLogger(CommonScheduler.class);

    @Async("taskExecutor")
    @Scheduled(cron = "0/5 * * * * *")
    public void schedulerOne(){
        log.info("---定时任务1---");
    }

    /**
     * 基于指定的配置Bean异步执行相应的业务逻辑
     */
    @Async("taskExecutor")
    @Scheduled(cron = "0/6 * * * * *")
    public void schedulerTwo(){
        log.info("---定时任务2---");
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Async("taskExecutor")
    @Scheduled(cron = "0/7 * * * * *")
    public void schedulerThree(){
        log.info("---定时任务3---");

        try {
            Thread.sleep(4000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
