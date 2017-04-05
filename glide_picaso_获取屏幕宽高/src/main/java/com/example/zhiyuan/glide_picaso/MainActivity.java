package com.example.zhiyuan.glide_picaso;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView glideImageView;
    private ImageView picassoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glideImageView = (ImageView) findViewById(R.id.glideImageView);
        picassoImageView = (ImageView) findViewById(R.id.picassoImageView);

        //1只有activity可以使用WindowManager，否则应该使用Context.getResources().getDisplayMetrics()来获取。

        //在activity中设置
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager manger = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        manger.getDefaultDisplay().getMetrics(dm);

        //是获取到Activity的实际屏幕信息。
        WindowManager windowManager = getWindowManager();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;

        //2//依赖于手机系统，获取到的是系统的屏幕信息
        DisplayMetrics displayMetrics1 = this.getResources().getDisplayMetrics();
        int widthPixels1 = displayMetrics1.widthPixels;//屏幕宽度（像素）
        int heightPixels1 = displayMetrics1.heightPixels;//屏幕宽度（像素）
    }

    public void glidePic(View view) {
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg").placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into(glideImageView);
    }

    public void picassoPic(View view) {
        Picasso.with(this)
                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                .into(picassoImageView);
    }
}
