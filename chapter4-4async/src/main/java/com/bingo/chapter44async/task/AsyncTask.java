package com.bingo.chapter44async.task;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @Author: tyx
 * @Date: create in 2018/7/25 17:07
 * @Description:
 */
@Component
@Slf4j
public class AsyncTask {

    private Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Async("taskExecutor")
    public Future<String> executeTask1() throws InterruptedException {
        logger.info("task1运行线程");
        System.out.println("执行task1开始.........");
        long start = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task1结束，耗时：" + (end-start) + "ms");
        return new AsyncResult<>("task1完成");
    }

    @Async("taskExecutor")
    public Future<String> executeTask2() throws InterruptedException {
        logger.info("task2运行线程");
        System.out.println("执行task2开始.........");
        long start = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task2结束，耗时：" + (end-start) + "ms");
        return new AsyncResult<>("task2完成");
    }

    @Async("taskExecutor")
    public Future<String> executeTask3() throws InterruptedException {
        logger.info("task3运行线程");
        System.out.println("执行task3开始.........");
        long start = System.currentTimeMillis();
        Thread.sleep(new Random().nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("task3结束，耗时：" + (end-start) + "ms");
        return new AsyncResult<>("task3完成");
    }

    @Async("taskSchedulerExecutor")
    public void executeScheduler1() throws InterruptedException {
        log.info("执行Scheduler1开始.........");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("Scheduler1结束，耗时：{}ms", (end-start));
    }

    @Async("taskSchedulerExecutor")
    public void executeScheduler2() throws InterruptedException {
        log.info("执行Scheduler2开始.........");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("Scheduler3结束，耗时：{}ms", (end-start));
    }

    @Async("taskSchedulerExecutor")
    public void executeScheduler3() throws InterruptedException {
        log.info("执行Scheduler3开始.........");
        long start = System.currentTimeMillis();
        log.info(stringRedisTemplate.randomKey());
        long end = System.currentTimeMillis();
        log.info("Scheduler3结束，耗时：{}ms", (end-start));
    }

}
