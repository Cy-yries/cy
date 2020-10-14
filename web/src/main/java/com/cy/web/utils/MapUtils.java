package com.cy.web.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapUtils
 * @Author Yin
 * @Date 2020/10/13 11:40
 * @Version 1.0
 **/
public class MapUtils {

    public static <T>T convertObj(Object map, Class<T> obj) {

        return JSONObject.parseObject(JSONObject.toJSONString(map), obj);
    }

    public static Map<String, String> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String value = String.valueOf(field.get(obj));
            map.put(fieldName, value);
        }
        return map;
    }

}
