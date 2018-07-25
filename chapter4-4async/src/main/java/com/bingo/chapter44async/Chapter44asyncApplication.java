package com.bingo.chapter44async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
public class Chapter44asyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chapter44asyncApplication.class, args);
	}

	@Bean("taskExecutor")
	Executor taskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(3);
		taskExecutor.setMaxPoolSize(6);
		taskExecutor.setKeepAliveSeconds(60);
		taskExecutor.setQueueCapacity(100);
		taskExecutor.setThreadNamePrefix("TaskExecutor-");
		taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		return taskExecutor;
	}

	@Bean("taskSchedulerExecutor")
	Executor taskSchedulerExecutor() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(20);
		threadPoolTaskScheduler.setThreadNamePrefix("TaskSchedulerExecutor-");
		// 置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
		threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
		// 线程池中任务的等待时间，如果超过这个时候还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
		threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
		return threadPoolTaskScheduler;
	}
}
