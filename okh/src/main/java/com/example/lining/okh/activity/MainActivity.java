package com.example.lining.okh.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.lining.okh.R;
import com.example.lining.okh.adapter.MyAdapter;
import com.example.lining.okh.application.MyApplicationConstants;
import com.example.lining.okh.model.bean.Bean;
import com.example.lining.okh.model.http.CallBackData;
import com.example.lining.okh.model.http.HttpUtils;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.List;


public class MainActivity extends AppCompatActivity implements CallBackData<Bean>, PullToRefreshListView.OnRefreshListener2<ListView> {

    private PullToRefreshListView pull;
    private int currenPage = 1;
    private boolean isNeedClear = false;
    private MyAdapter adapter;
    private String url;
    private List<Bean.ResultBean.RowsBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        url = MyApplicationConstants.getUrl();
        HttpUtils.loadDataFromServer(url, Bean.class, this);
        pull.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //                Intent intent= new Intent(MainActivity.this,WebViewShow.class);
                //                intent.putExtra("11",data.get(position).getUrl());
                //                startActivity(intent);
            }
        });

    }

    private void initData() {
        adapter = new MyAdapter(this);
        pull.setAdapter(adapter);
    }

    private void initView() {
        pull = (PullToRefreshListView) findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setOnRefreshListener(this);
    }

    //下拉加载
    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        isNeedClear = true;
        currenPage++;
        url = MyApplicationConstants.getUrl();
        HttpUtils.loadDataFromServer(url, Bean.class, this);
    }

    //上拉刷新
    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        isNeedClear = false;
        currenPage++;
        url = MyApplicationConstants.getUrl();
        HttpUtils.loadDataFromServer(url, Bean.class, this);
    }

    @Override
    public void success(Bean bean) {
        data = bean.getResult().getRows();
        adapter.addData(data, isNeedClear);
        adapter.notifyDataSetChanged();
        pull.onRefreshComplete();
    }
}
