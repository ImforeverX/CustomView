package com.example.lining.okh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lining.okh.R;
import com.example.lining.okh.model.bean.Bean;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李宁 on 2017/2/20.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Bean.ResultBean.RowsBean>  bl = new ArrayList<>();

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
                return bl.size();
//        return 20;
    }

    @Override
    public Bean.ResultBean.RowsBean getItem(int position) {
                return bl.get(position);

//        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            holder.iv = (ImageView) convertView.findViewById(R.id.iv);
            holder.tv1 = (TextView) convertView.findViewById(R.id.tv1);
            holder.tv2 = (TextView) convertView.findViewById(R.id.tv2);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //添加数据
                Bean.ResultBean.RowsBean item = getItem(position);
                holder.tv1.setText(item.getInfo().getAddress());
                holder.tv2.setText(item.getInfo().getLat());
                ImageLoader.getInstance().displayImage(getItem(position).getInfo().getDefault_image(), holder.iv);
        return convertView;
    }

    public void addData(List<Bean.ResultBean.RowsBean> data, boolean isNeedClear) {
        if (data != null) {
            if (isNeedClear) {
                bl.clear();
            }
            bl.addAll(data);
        }
    }

    static class ViewHolder {
        TextView tv1;
        TextView tv2;
        ImageView iv;
    }
}
