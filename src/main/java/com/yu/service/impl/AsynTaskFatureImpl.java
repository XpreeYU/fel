package com.yu.service.impl;

import com.yu.service.AsynTaskFature;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * ClassName AsynTaskFatureImpl
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/4 17:59
 **/
public class AsynTaskFatureImpl implements AsynTaskFature {


    @Async
    @Override
    public Future<String> task1() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task1任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
        return new AsyncResult<String>("task1执行完毕");
    }

    @Override
    public Future<String> task2() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task2任务耗时:" + (currentTimeMillis1 - currentTimeMillis) + "ms");
        return new AsyncResult<String>("task2执行完毕");
    }


}
