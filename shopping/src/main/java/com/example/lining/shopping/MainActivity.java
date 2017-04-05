package com.example.lining.shopping;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AbsListView.OnScrollListener {


    private ListView mListView;
    private TextView mTv_sum;
    private int currentCount = 0;
    private int eacha_count = 20;
    private List<Product> products = new ArrayList<>();
    private ProductAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);

        mTv_sum = (TextView) findViewById(R.id.tv_sum);

        initData();

        mAdapter = new ProductAdapter(MainActivity.this, products);
        mListView.setAdapter(mAdapter);
        mListView.setOnScrollListener(this);
    }

    private void initData() {

        for (int i = currentCount; i < currentCount + eacha_count; i++) {

            products.add(new Product("我是商品" + i, i, i));

        }
    }

    //滑动状态改变
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        //静止状态
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            //且可以看到的最后一个条目是集合的最后一个
            int lastVisiblePosition = view.getLastVisiblePosition();
            if (lastVisiblePosition == products.size() - 1) {
                //加载数据
                currentCount += eacha_count;
                //加载数据
                initData();
                mAdapter.notifyDataSetChanged();
            }
        }
    }

    //滑动的过程
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    public void checkAll(View view) {

        for (int i = 0; i < products.size(); i++) {

            products.get(i).setChecked(true);
            mAdapter.notifyDataSetChanged();
            setPrice();
        }
    }

    public void setPrice() {
        int price = 0;
        for (int i = 0; i < products.size(); i++) {
            //            boolean checked = productList.get(i).isChecked();
            boolean checked = products.get(i).isChecked();
            if (checked) {

                price += products.get(i).getPrice() * products.get(i).getCount();

            }

            mTv_sum.setText("总价格"+price + "$");
        }
    }

    public void checkNone(View view) {

        for (int i = 0; i < products.size(); i++) {

            //productList.get(i).setChecked(!productList.get(i).isChecked());
            products.get(i).setChecked(!products.get(i).isChecked());
        }
        //刷新
        mAdapter.notifyDataSetChanged();
        setPrice();
    }
}
