package com.example.lining.recycler_my.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.lining.recycler_my.R;


/**
 * Created by zhiyuan on 17/3/21.
 */

public class RSecondTypeHolder extends RecyclerView.ViewHolder {

    public  final TextView tv_item;

    public RSecondTypeHolder(View itemView) {
        super(itemView);
        tv_item = (TextView) itemView.findViewById(R.id.tv_item);

    }

//    public void setData(String data) {
//        this.data = data;
//
//
//    }
}
