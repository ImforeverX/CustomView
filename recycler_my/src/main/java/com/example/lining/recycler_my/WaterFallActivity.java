package com.example.lining.recycler_my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.lining.recycler_my.adapter.RWaterWallAdapter;
import com.example.lining.recycler_my.listener.OnRecyclerViewItemClickListener;

import java.util.ArrayList;

public class WaterFallActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> dataList;
    private RWaterWallAdapter rWaterWallAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initData();
//        recyclerView.setItemAnimator();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, RecyclerView.VERTICAL));
        rWaterWallAdapter = new RWaterWallAdapter(this, dataList);

        rWaterWallAdapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(WaterFallActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int position) {
                Toast.makeText(WaterFallActivity.this, "长按了" + position, Toast.LENGTH_SHORT).show();

            }
        });
        recyclerView.setAdapter(rWaterWallAdapter);


    }

    private void initData() {
        dataList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            dataList.add("条目" + i);
        }
    }

    public void addItem(View view) {

        dataList.add(2, "新的条目");
        rWaterWallAdapter.notifyItemInserted(2);
    }


    public void deleteItem(View view) {
        dataList.remove(3);
        rWaterWallAdapter.notifyItemRemoved(3);
    }
}
