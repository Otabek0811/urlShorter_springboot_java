package uz.shortUrl.spring_boot_short_url.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.Executor;

@Slf4j
@Configuration
public class GlobalAsyncConfigurer  implements AsyncConfigurer {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(Runtime.getRuntime().availableProcessors());
        executor.setKeepAliveSeconds(30);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("pool-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (e,method,params)-> {
            log.error(
                    "Exception message - {}, method name - {}, params - {}, time - {}",
                    e.getMessage(),
                    method.getName(),
                    Arrays.toString(params),
                    LocalDateTime.now(),
                    e
            );
        };
    }
}

