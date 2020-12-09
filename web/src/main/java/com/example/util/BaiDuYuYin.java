package com.example.util;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

/**
 * 百度语音识别
 */
public class BaiDuYuYin {

    public static JSONObject getWenZi(){
        AipSpeech client = new AipSpeech("23052282", "hVmagyDGn4MSFx3iwgNj5Wq7", "DLG4I0tnA3HSlot6FvYBPIUxV0ud1C71");
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        JSONObject res = client.asr("D:\\QQDownloads\\001.m4a", "m4a", 16000, null);
        return res;
    }

}
