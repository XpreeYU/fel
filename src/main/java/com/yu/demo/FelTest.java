package com.yu.demo;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import com.greenpineyu.fel.context.MapContext;
import com.greenpineyu.fel.function.CommonFunction;
import com.greenpineyu.fel.function.Function;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName FelTest
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 14:56
 **/
public class FelTest {

    public static void main(String[] args) {
       // test1();
        test2();
        test3();
        test4();
    }

    /**
     * 表达式计算
     */
    public static void test1(){
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        ctx.set("a", 1);
        ctx.set("b", 2);
        ctx.set("c", 3);
        Object result = fel.eval("a*b+c >0 && a<b");
        System.out.println(result);
    }


    /**
     * 访问对象属性,(同时指定特定上下文)
     */
    public static void test2(){

        FelEngine felEngine = new FelEngineImpl();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name","余建松");
        FelContext mapContext = new MapContext();
        mapContext.set("obj",params);

        Object result = felEngine.eval("obj.name",mapContext);
        System.out.println(result);
    }


    /**
     * 调用静态方法
     * 格式："$('class').method(var0,var1..,varn)"
     * class:类的全路径
     */
    public static void test3(){
        Object eval = FelEngine.instance.eval("$('Math').min(1,2)");
        System.out.println(eval);
    }

    /**
     * 自定义函数
     */
    public static void test4(){

        Function function = new CommonFunction() {
            /**
             * 设置函数名称
             * @return
             */
            public String getName() {
                return "isEmpty";
            }

            /**
             * 方法体
             * @param objects
             * @return
             */
            @Override
            public Object call(Object[] objects) {
                if(objects==null || objects.length<1){
                    return true;
                }
                Object object = objects[0];
                if(object==null){
                    return true;
                }
                return false;
            }
        };

        FelEngineImpl felEngine = new FelEngineImpl();
        //添加自定义函数
        felEngine.addFun(function);

        felEngine.getContext().set("name","chenjiahao");

        Object eval = felEngine.eval("isEmpty(name)");
        System.out.println(eval);

        eval = felEngine.eval("isEmpty(age)");
        System.out.println(eval);

    }

}
