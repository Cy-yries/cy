package com.cy.web.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName MapConvertObj
 * @Author Yin
 * @Date 2020/10/13 11:40
 * @Version 1.0
 **/
public class MapConvertObj {

    public static <T>T convertObj(Object map, Class<T> obj) {
        return JSONObject.parseObject(JSONObject.toJSONString(map), obj);
    }

}
