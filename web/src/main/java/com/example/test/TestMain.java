package com.example.test;

import com.baidu.aip.speech.AipSpeech;
import com.example.util.BaiDuYuYin;
import com.example.util.UrlUtil;
import net.sf.json.JSONObject;

public class TestMain {

    public static void main(String[] args) {
        /*JSONObject res = BaiDuYuYin.getWenZi();
        System.out.println(res);*/
        String a = UrlUtil.sendGet("http://119.146.189.250:9011/zhlxqms/leaderWindowController.do?getDepartList");
        JSONObject json = JSONObject.fromObject(a);
        System.out.println(json.get("data"));
    }

}
