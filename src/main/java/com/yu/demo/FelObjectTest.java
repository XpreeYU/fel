package com.yu.demo;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

import java.util.*;

/**
 * ClassName FelObjectTest
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 16:24
 **/
public class FelObjectTest {


    public static void main(String[] args) {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();
        Foo foo = new Foo();
        foo.setSize("123");
        ctx.set("foo", foo);

        Map<String, String> m = new HashMap<String, String>();
        m.put("ElName", "fel");
        ctx.set("m", m);

        //调用foo.getSize()方法。
        Object result = fel.eval("foo.size");
        System.out.println(result);

        //调用foo.isSample()方法。
        result = fel.eval("foo.sample");

        //foo没有name、getName、isName方法
        //foo.name会调用foo.get("name")方法。
        result = fel.eval("foo.name");

        //m.ElName会调用m.get("ElName");
        result = fel.eval("m.ElName");
    }


    public static void felList() {
        FelEngine fel = new FelEngineImpl();
        FelContext ctx = fel.getContext();

        //数组
        int[] intArray = {1, 2, 3};
        ctx.set("intArray", intArray);
        //获取intArray[0]
        String exp = "intArray[0]";
        System.out.println(exp + "->" + fel.eval(exp));

//List
        List<Integer> list = Arrays.asList(1, 2, 3);
        ctx.set("list", list);
//获取list.get(0)
        exp = "list[0]";
        System.out.println(exp + "->" + fel.eval(exp));

//集合
        Collection<String> coll = Arrays.asList("a", "b", "c");
        ctx.set("coll", coll);
//获取集合最前面的元素。执行结果为"a"
        exp = "coll[0]";
        System.out.println(exp + "->" + fel.eval(exp));

//迭代器
        Iterator<String> iterator = coll.iterator();
        ctx.set("iterator", iterator);
//获取迭代器最前面的元素。执行结果为"a"
        exp = "iterator[0]";
        System.out.println(exp + "->" + fel.eval(exp));

//Map
        Map<String, String> m = new HashMap<String, String>();
        m.put("name", "HashMap");
        ctx.set("map", m);
        exp = "map.name";
        System.out.println(exp + "->" + fel.eval(exp));

//多维数组
        int[][] intArrays = {{11, 12}, {21, 22}};
        ctx.set("intArrays", intArrays);
        exp = "intArrays[0][0]";
        System.out.println(exp + "->" + fel.eval(exp));

//多维综合体，支持数组、集合的任意组合。
        List<int[]> listArray = new ArrayList<int[]>();
        listArray.add(new int[]{1, 2, 3});
        listArray.add(new int[]{4, 5, 6});
        ctx.set("listArray", listArray);
        exp = "listArray[0][0]";
        System.out.println(exp + "->" + fel.eval(exp));
    }
}
