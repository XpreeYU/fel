package com.yu.service;

import java.util.concurrent.Future;

/**
 * ClassName AsynTaskFature
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/4 17:58
 **/
public interface AsynTaskFature {
    public Future<String> task1() throws InterruptedException;


    public Future<String> task2() throws InterruptedException;

}
