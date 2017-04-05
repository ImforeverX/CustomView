package com.example.lining.okh.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;


/**
 * Created by 李宁 on 2017/2/15.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(true);

        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)


                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
