package com.example.lining.tablayout.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.lining.tablayout.R;
import com.example.lining.tablayout.adapter.MyAdapter;
import com.example.lining.tablayout.fragmnet_view.Fm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager vp;
    private String arr[] = {"星期一", "星期2", "星期三", "星期4", "星期五", "星期6", "星期七"};
    List<Fragment> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();

    }

    private void initData() {
        for (int i = 0; i < arr.length; i++) {
            Fm fm = new Fm();
            list.add(fm);
        }
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), this, list, arr);
        vp.setAdapter(adapter);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setupWithViewPager(vp);

    }

    private void initView() {

        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
    }
}
