package com.example.lining.recycler_my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lining.recycler_my.adapter.RSimpleAdapter;

import java.util.ArrayList;

public class SimpleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> dataList;
    private RSimpleAdapter rSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        //找控件
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //准备数据
        initData();
        //展示数据
        //设置布局管理者
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rSimpleAdapter = new RSimpleAdapter(this, dataList);
        //添加分界线
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(rSimpleAdapter);
    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add("条目"+i);
        }
    }

    public void singleLine(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //刷新适配器
        rSimpleAdapter.notifyDataSetChanged();
    }

    public void moreLine(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        //刷新适配器
        rSimpleAdapter.notifyDataSetChanged();

    }

    public void singleHorizontal(View view) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        //刷新适配器
        rSimpleAdapter.notifyDataSetChanged();

    }

    public void moreHorizontal(View view) {
        recyclerView.setLayoutManager(new GridLayoutManager(this,5,RecyclerView.HORIZONTAL,false));
        //刷新适配器
        rSimpleAdapter.notifyDataSetChanged();
    }
}
