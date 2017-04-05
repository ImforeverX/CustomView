package com.example.lining.recycler_my;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.lining.recycler_my.adapter.RWaterWallAdapter;

import java.util.ArrayList;


public class RefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<String> dataList;
    private RWaterWallAdapter rWaterWallAdapter;

    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //设置
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,RecyclerView.VERTICAL));

        initData();
        rWaterWallAdapter = new RWaterWallAdapter(this, dataList);
        recyclerView.setAdapter(rWaterWallAdapter);
        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GRAY,Color.GREEN);

        swipeRefreshLayout.setOnRefreshListener(this);
    }
    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add("条目" + i);
        }
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新条目
                dataList.add(0,"刷新了一下下");
                //刷新适配器
                rWaterWallAdapter.notifyDataSetChanged();
                //隐藏小圆圈
                swipeRefreshLayout.setRefreshing(false);
            }
        },2000);
    }
}
