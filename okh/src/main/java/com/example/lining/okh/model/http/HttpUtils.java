package com.example.lining.okh.model.http;


import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by 李宁 on 2017/2/15.
 */

public class HttpUtils {

    public static <T> void loadDataFromServer(final String url, final Class<T> clazz, final CallBackData callBackData) {

        OkHttpUtils
                .get()
                .url(url)
                //                .addParams("username", "hyman")
                //                .addParams("password", "123")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        T t = gson.fromJson(response, clazz);
                        callBackData.success(t);
                    }
                });
       /* x.http().get(new RequestParams(url), new Callback.CommonCallback<String>(){
            @Override
            public void onSuccess(String result) {
                Gson gson= new Gson();
//                final T t = gson.fromJson(result, clazz);
                T t = gson.fromJson(result, clazz);
                callBackData.success(t);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
            }
            @Override
            public void onCancelled(CancelledException cex) {
            }
            @Override
            public void onFinished() {
            }
        });*/
    }
}
