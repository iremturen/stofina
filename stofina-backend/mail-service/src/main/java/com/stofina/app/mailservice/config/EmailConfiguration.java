package com.stofina.app.mailservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class EmailConfiguration {
    public static final String MAIL_SEND_EXECUTOR = "mailSendThreadPoolTaskExecutor";

    @Bean(name = MAIL_SEND_EXECUTOR, destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor mailSendExecutor() {
        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(3);
        threadPoolTaskExecutor.setCorePoolSize(0);
        threadPoolTaskExecutor.setKeepAliveSeconds(120);
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setQueueCapacity(1000);
        return threadPoolTaskExecutor;
    }

}