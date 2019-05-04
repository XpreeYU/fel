package com.yu.demo;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

/**
 * ClassName felDemo
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/24 21:57
 **/
public class felDemo {
    public static void main(String args[]){
        FelEngine fel = new FelEngineImpl();
        Object result = fel.eval("5000*12+7500");
        System.out.println(result);


        FelContext ctx = fel.getContext();
        ctx.set("单价", 5000);
        ctx.set("数量", 12);
        ctx.set("运费", 7500);
        Object result2 = fel.eval("单价*数量+运费");
        System.out.println(result2);

    }
}
