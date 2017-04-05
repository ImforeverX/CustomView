package com.example.lining.recycler_my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.lining.recycler_my.adapter.RWaterWallAdapter;
import com.example.lining.recycler_my.callback.ItemTouchCallBack;

import java.util.ArrayList;


public class RDragActivity extends AppCompatActivity {

    private RWaterWallAdapter rWaterWallAdapter;
    private ArrayList<String> dataList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rdrag);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initData();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));
        //关联RecyclerView
        rWaterWallAdapter = new RWaterWallAdapter(this, dataList);
        recyclerView.setAdapter(rWaterWallAdapter);

        //创建回调
        ItemTouchCallBack itemTouchCallBack = new ItemTouchCallBack();
        //设置帮助类
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallBack);
        //进行关联
        itemTouchHelper.attachToRecyclerView(recyclerView);

        itemTouchCallBack.setAdapter(rWaterWallAdapter);
    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add("条目" + i);
        }
    }
}
