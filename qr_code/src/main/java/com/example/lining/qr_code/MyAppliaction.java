package com.example.lining.qr_code;

import android.app.Application;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by 李宁 on 2017/3/27.
 */
public class MyAppliaction extends Application {

        @Override
        public void onCreate() {
                super.onCreate();
                ZXingLibrary.initDisplayOpinion(this);
        }



}
