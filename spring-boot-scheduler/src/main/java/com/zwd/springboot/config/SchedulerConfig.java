package com.zwd.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author 随风逐梦
 * @create 2019-11-14 16:37
 */
@Configuration
public class SchedulerConfig {

    /**
     * 线程池  多线程
     * @return
     */
    @Bean("taskExecutor")
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(4);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(8);
        taskExecutor.initialize();;
        return taskExecutor;
    }
}
