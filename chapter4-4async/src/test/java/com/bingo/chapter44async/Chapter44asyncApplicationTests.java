package com.bingo.chapter44async;

import com.bingo.chapter44async.task.AsyncTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Chapter44asyncApplicationTests {

	@Autowired
	AsyncTask asyncTask;

	@Test
	public void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
		Future<String> result1 = asyncTask.executeTask1();
        Future<String> result2 = asyncTask.executeTask2();
        Future<String> result3 = asyncTask.executeTask3();
        while (true) {
            if (result1.isDone() && result2.isDone() && result3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - start) + "ms");
    }

    @Test
    public void threadPoolTest() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            asyncTask.executeScheduler1();
            asyncTask.executeScheduler2();
            asyncTask.executeScheduler3();

            if (i == 999) {
                System.exit(0);
            }
        }
    }

    @Test
    public void futureTest() throws Exception {
	    Future<String> future = asyncTask.executeTask1();
	    String result = future.get(5, TimeUnit.SECONDS);
	    log.info(result);
    }

}
