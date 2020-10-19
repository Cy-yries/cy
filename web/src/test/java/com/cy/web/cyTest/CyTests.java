package com.cy.web.cyTest;

import com.cy.web.utils.PoiUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @ClassName CyTests
 * @Author Yin
 * @Date 2020/10/4 18:10
 * @Version 1.0
 **/

public class CyTests {

    @Test
    public void demo_1() throws IOException {
        String path = "C:\\Users\\28587\\Documents\\WeChat Files\\wxid_tfq5gayl6ix122\\FileStorage\\File\\2020-10\\综合报表(1).xlsx";
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        List<String[]> readExcel = PoiUtils.readExcel(inputStream, file.getName(), 4, 0);
        System.out.println("readExcel = " + readExcel);
        for (String[] strings : readExcel) {
            System.out.println();
            System.out.println(Arrays.toString(strings));
        }
        List<String[]> result = new ArrayList<>();
    }

    @Test
    public void demo_2() {
        String s = "蔬果鲜\n" +
                "意玺生活超市\n" +
                "果美香果蔬\n" +
                "佰事佳生活超市\n" +
                "鲜蔬菜水果\n" +
                "快客生鲜超市\n" +
                "社区果蔬超市\n" +
                "红六富果蔬超市\n" +
                "唯佳果蔬\n" +
                "聚鲜源水果蔬菜超市\n" +
                "杨子每日鲜果蔬店\n" +
                "时令鲜果蔬\n" +
                "欣欣果蔬\n" +
                "润荷果蔬超市\n" +
                "润荷果蔬超市\n" +
                "每日鲜蔬菜水果店\n" +
                "万客隆\n" +
                "小伙计便利店\n" +
                "民润生活超市\n" +
                "恒雨超市\n" +
                "熙春园\n" +
                "优口福生活特色馆\n" +
                "佳士多便利店\n" +
                "荣旺生活超市\n" +
                "绿上鲜\n" +
                "高霞果蔬店\n" +
                "好客家超市\n" +
                "爱瑜鲜生\n" +
                "众客隆生活超市\n" +
                "佰斯特超市\n" +
                "榴芒果蔬\n" +
                "小胖果蔬\n" +
                "颐美佳生活超市\n" +
                "晓路果蔬\n" +
                "永乐福\n" +
                "锅圈食汇火锅烧烤食材超市\n" +
                "乐博便利店\n" +
                "香溪美地爱心公社\n" +
                "每日优选\n" +
                "小来鲜果蔬\n" +
                "菜多多\n" +
                "灵悦生活超市\n" +
                "闹特特便利店\n" +
                "百果嘉源\n" +
                "董洋果业\n" +
                "小郭蔬菜店\n" +
                "小温果蔬\n" +
                "福兴莱果蔬超市\n" +
                "季时鲜果蔬\n" +
                "福先生生鮮超市\n" +
                "塞上宝贝蔬果超市\n" +
                "鲜到家\n" +
                "石海全果蔬店\n" +
                "胖嘟嘟果蔬超市\n" +
                "鑫鑫惠超市\n" +
                "鑫雅便利店\n" +
                "熙园便利店\n" +
                "家优福便利店\n" +
                "鑫鑫乐多便利店\n" +
                "佳百利商店\n" +
                "万丰超市\n" +
                "鑫彤便利店\n" +
                "苗家果蔬超市\n" +
                "金佰汇果蔬超市\n" +
                "每日优选便利店\n" +
                "安佳超市\n" +
                "珑悦便利店\n" +
                "满祥隆生活超市\n" +
                "快递驿站景辉便利店\n" +
                "张雪玲蔬果店\n" +
                "嘉亿亲和超市\n" +
                "宜佰家超市\n" +
                "新顺风商店\n" +
                "华府超市\n" +
                "悦来客便利店\n" +
                "YU Ki优品百货\n" +
                "江佑百货便利店\n" +
                "银川市金凤区家家悦超市\n" +
                "厚生记官方店\n" +
                "绿源果蔬\n" +
                "民生新天地便利店\n" +
                "瑞鑫超市\n" +
                "果唯伊\n" +
                "鸿兴源超市\n" +
                "欢易购超市\n" +
                "民润超市\n" +
                "未来城快递超市\n" +
                "信佰佳生活超市\n" +
                "懒猫社长便利店\n" +
                "速购便利店\n" +
                "鲜鲜汇便利店\n"+
                "大通超市\n";
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

    @Test
    public void demo_3() {

        String s = "蔬果鲜\n" +
                "意玺生活超市\n" +
                "果美香果蔬\n" +
                "佰事佳生活超市\n" +
                "鲜蔬菜水果\n" +
                "快客生鲜超市\n" +
                "社区果蔬超市\n" +
                "红六富果蔬超市\n" +
                "唯佳果蔬\n" +
                "聚鲜源水果蔬菜超市\n" +
                "杨子每日鲜果蔬店\n" +
                "时令鲜果蔬\n" +
                "欣欣果蔬\n" +
                "润荷果蔬超市\n" +
                "润荷果蔬超市\n" +
                "每日鲜蔬菜水果店\n" +
                "万客隆\n" +
                "小伙计便利店\n" +
                "民润生活超市\n" +
                "恒雨超市\n" +
                "熙春园\n" +
                "优口福生活特色馆\n" +
                "佳士多便利店\n" +
                "荣旺生活超市\n" +
                "绿上鲜\n" +
                "高霞果蔬店\n" +
                "好客家超市\n" +
                "爱瑜鲜生\n" +
                "众客隆生活超市\n" +
                "佰斯特超市\n" +
                "榴芒果蔬\n" +
                "小胖果蔬\n" +
                "颐美佳生活超市\n" +
                "晓路果蔬\n" +
                "永乐福\n" +
                "锅圈食汇火锅烧烤食材超市\n" +
                "乐博便利店\n" +
                "香溪美地爱心公社\n" +
                "每日优选\n" +
                "小来鲜果蔬\n" +
                "菜多多\n" +
                "灵悦生活超市\n" +
                "闹特特便利店\n" +
                "百果嘉源\n" +
                "董洋果业\n" +
                "小郭蔬菜店\n" +
                "小温果蔬\n" +
                "福兴莱果蔬超市\n" +
                "季时鲜果蔬\n" +
                "福先生生鮮超市\n" +
                "塞上宝贝蔬果超市\n" +
                "鲜到家\n" +
                "石海全果蔬店\n" +
                "胖嘟嘟果蔬超市\n" +
                "鑫鑫惠超市\n" +
                "鑫雅便利店\n" +
                "熙园便利店\n" +
                "家优福便利店\n" +
                "鑫鑫乐多便利店\n" +
                "佳百利商店\n" +
                "万丰超市\n" +
                "鑫彤便利店\n" +
                "苗家果蔬超市\n" +
                "金佰汇果蔬超市\n" +
                "每日优选便利店\n" +
                "安佳超市\n" +
                "珑悦便利店\n" +
                "满祥隆生活超市\n" +
                "快递驿站景辉便利店\n" +
                "张雪玲蔬果店\n" +
                "嘉亿亲和超市\n" +
                "宜佰家超市\n" +
                "新顺风商店\n" +
                "华府超市\n" +
                "悦来客便利店\n" +
                "YU Ki优品百货\n" +
                "江佑百货便利店\n" +
                "银川市金凤区家家悦超市\n" +
                "厚生记官方店\n" +
                "绿源果蔬\n" +
                "民生新天地便利店\n" +
                "瑞鑫超市\n" +
                "果唯伊\n" +
                "鸿兴源超市\n" +
                "欢易购超市\n" +
                "民润超市\n" +
                "未来城快递超市\n" +
                "信佰佳生活超市\n" +
                "懒猫社长便利店\n" +
                "速购便利店\n" +
                "鲜鲜汇便利店\n" +
                "大通超市\n";
        String[] strings = s.split("\n");
        s=" 玺云台南门\n" +
                "海亮14号门\n" +
                "（闭店）\n" +
                "碧桂园翡翠湾\n" +
                "逸馨苑\n" +
                "海亮国际社区5号\n" +
                "银馨苑四区\n" +
                "金域蓝湾\n" +
                "家园小时代\n" +
                "庆丰苑南门\n" +
                "中海城东郡西门\n" +
                "幸福世家西门\n" +
                "金海明月花园\n" +
                "苏荷阳光\n" +
                "苏荷阳光\n" +
                "在水一方A区\n" +
                "江南水乡景园b区\n" +
                "虹桥御景\n" +
                "时代之星东门\n" +
                "水木清苑\n" +
                "太阳都市花园北门\n" +
                "金榜铭园\n" +
                "金泰华府\n" +
                "太阳都市花园南门\n" +
                "（闭店）\n" +
                "天山熙湖北门\n" +
                "（闭店）\n" +
                "艾依公馆\n" +
                "派胜沁园\n" +
                "天山熙湖西门\n" +
                "丽景湖畔·金秋园\n" +
                "京能凤凰尚筑内\n" +
                "（闭店）\n" +
                "天山熙湖一期南门\n" +
                "御景湖城南门\n" +
                "观湖一号\n" +
                "天山熙湖二区南门\n" +
                "香溪美地北门\n" +
                "（闭店）\n" +
                "天际中心·云顶\n" +
                "丽水家园南门\n" +
                "金宇名庭北区\n" +
                "鲁银城市公元北门\n" +
                "阅海万家F3区\n" +
                "云和家园南门\n" +
                "天嘉人和里\n" +
                "阅海万家f3西门\n" +
                "宝湖湾西门\n" +
                "庆丰苑\n" +
                " 宝湖福邸西门\n" +
                "安和园东门\n" +
                "（闭店）\n" +
                "金鹰国际村南门\n" +
                "艾依水郡南门\n" +
                "长兴花园A区东门\n" +
                "宝湖庭院北门\n" +
                "澳海熙园南门\n" +
                "（闭店）\n" +
                "御景湖城东门\n" +
                "（闭店）\n" +
                "宁安宜居北门\n" +
                "宝湖庭院北门\n" +
                "东方尚都东南门\n" +
                "（闭店）\n" +
                "（闭店）\n" +
                "华府万和城北门\n" +
                "碧桂园珑悦湾南门\n" +
                "宝湖锦都西门\n" +
                "宝湖锦都东门\n" +
                "（闭店）\n" +
                "隆瑞源\n" +
                "五里水乡南门\n" +
                "中海城东郡南门\n" +
                "华府万和城西门\n" +
                "中海锦园南门\n" +
                "中海锦园东门\n" +
                "中海国际橙郡东门\n" +
                "绿地香树花城西门\n" +
                "\n" +
                "蓝山名邸\n" +
                "民生城市花园北门\n" +
                "盈南家园3期一区北门\n" +
                "湖畔嘉园三区内\n" +
                "未来城北门\n" +
                "未来城北门\n" +
                "昊天大院南门\n" +
                "未来城内\n" +
                "云风花苑西门\n" +
                "建发兴洲花园B区西门\n" +
                "建发兴洲花园A区南门\n" +
                "湖畔嘉苑润丰园南门\n"  +
                "阅海万家F3西门\n";
        String[] stringAdds = s.split("\n");
        for (int i=0;i<stringAdds.length;i++) {
            String str=strings[i];
            String strAdd=stringAdds[i];
            str = "SELECT o.`name`,o.address,o.id orgId,o.mark_map,b.id businessId,b.markId,b.`name` bname FROM org o,business b WHERE o.`name`='" + str + "' and o.mark_map=b.markId;";
              System.out.println(str);
        }

    }

}




