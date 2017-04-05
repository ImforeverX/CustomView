package com.example.lining.recycler_my.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lining.recycler_my.R;
import com.example.lining.recycler_my.holder.RFirstTypeHolder;
import com.example.lining.recycler_my.holder.RSecondTypeHolder;
import com.example.lining.recycler_my.holder.RThirdTypeHolder;

/**
 * Created by zhiyuan on 17/3/21.
 */

public class RMoreItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;

    private static final int FIRST_TYPE = 0;
    private static final int SECOND_TYPE = 1;
    private static final int THIRD_TYPE = 2;
    private int type = FIRST_TYPE;

    private String handsome;

    public RMoreItemAdapter(Context context, String handsome) {
        this.context = context;
        this.handsome = handsome;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.first_type_layout, parent, false);
                viewHolder = new RFirstTypeHolder(view);
                break;
            case 1:
                View view2 = LayoutInflater.from(context).inflate(R.layout.second_type_layout, parent, false);
                viewHolder = new RSecondTypeHolder(view2);
                break;
            case 2:
                View view3 = LayoutInflater.from(context).inflate(R.layout.third_type_layout, parent, false);
                viewHolder = new RThirdTypeHolder(view3);
                break;
        }
        return viewHolder;
    }

    /**
     * 判断当前条目类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case 0:
                type = FIRST_TYPE;
                break;
            case 1:
                type = SECOND_TYPE;
                break;
            case 2:
                type = THIRD_TYPE;
                break;
        }
        return type;
    }

    //设置数据使用
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //Bean.list1  Bean.list2  Bean.list3
        //获取条目类型
        int itemViewType = getItemViewType(position);

        switch (itemViewType) {
            case 0:

                break;
            case 1:
                //传递数据

                RSecondTypeHolder secondTypeHolder = (RSecondTypeHolder) holder;
                secondTypeHolder.tv_item.setText(handsome);

//                secondTypeHolder.setData("");
                break;
            case 2:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
