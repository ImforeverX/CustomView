package com.example.lining.okh.application;

/**
 * Created by 李宁 on 2017/2/20.
 */


import java.util.Date;

public class MyApplicationConstants {
    private static int pageSize = 15;

    //    public static final String APP_KEY = "0863c5f38bfa7a84bcceb6b629f91a35";
    //    public static final String URL_PICTURE = "http://v.juhe.cn/weixin/query?key=" + APP_KEY;

    public static String getUrl() {
        //String url = URL_PICTURE + "&page=" + currentPage + "&pagesize=" + pageSize + "&sort=asc&time=" + "1418816972";
        String url = "http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20160411091603";
        return url;
    }

    public static String getTimeStr() {
        return String.valueOf(new Date().getTime()).substring(0, 10);
    }

}



















