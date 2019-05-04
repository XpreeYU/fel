package com.yu.utils;

import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName ObjectFieldUtil
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/5/3 18:49
 **/
public class ObjectFieldUtil {

    /**
     * 获取属性名数组
     * */
    public static String[] getFiledName(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
        String[] fieldNames=new String[fields.length];
        for(int i=0;i<fields.length;i++){
//            System.out.println(fields[i].getType());
            fieldNames[i]=fields[i].getName();
        }
        return fieldNames;
    }

    /* 根据属性名获取属性值
     * */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {

            return null;
        }
    }

    public static void setFelContext(FelContext ctx, Object object){
        String[] fieldNames = getFiledName(object);
        for (String fieldName: fieldNames) {
            String name = fieldName;    //获取属性的名字
            Object value = getFieldValueByName(name,object);
            ctx.set(name, value);
        }

    }

}
