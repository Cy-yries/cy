package com.cy.web.cyTest;

import org.junit.jupiter.api.Test;

/**
 * @ClassName CySql
 * @Author Yin
 * @Date 2020/10/19 9:29
 * @Version 1.0
 **/
public class CySql {

    @Test
    //excel 复制转为 (,,,,,,)
    public void sql_1() {
        //in()
        String s = "";
        String[] strings = s.split("\n");
        String thiz = "";
        for (String str : strings) {
            str = "'" + str + "'" + ",";
            thiz = thiz + str;
            // System.out.println(str);
        }
        thiz = thiz.substring(0, thiz.length() - 1);
        System.out.println("thiz" + ":" + thiz);
    }

}
