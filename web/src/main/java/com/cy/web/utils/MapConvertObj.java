package com.cy.web.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @ClassName MapConvertObj
 * @Author Yin
 * @Date 2020/10/13 11:40
 * @Version 1.0
 **/
public class MapConvertObj {

    public static <T>T convertObj(Map map, Class<T> obj) {
        return JSONObject.parseObject(JSONObject.toJSONString(map), obj);
    }

}
