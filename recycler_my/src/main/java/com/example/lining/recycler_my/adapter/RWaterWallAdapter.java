package com.example.lining.recycler_my.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lining.recycler_my.R;
import com.example.lining.recycler_my.holder.RSimpleHolder;
import com.example.lining.recycler_my.listener.OnRecyclerViewItemClickListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zhiyuan on 17/3/21.
 */

public class RWaterWallAdapter extends RecyclerView.Adapter<RSimpleHolder> {
    private final Context context;
    private final ArrayList<String> dataList;
    private final ArrayList<Integer> heightList;
    private OnRecyclerViewItemClickListener onItemClickListener;


    public RWaterWallAdapter(Context context, ArrayList<String> dataList) {
        this.context=context;
        this.dataList=dataList;
        //定义出当前控件的高度
        heightList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            heightList.add((int) (100+(int)200*Math.random()));
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    /**
     * 关联相应的viewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RSimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //实例化布局view
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item, parent, false);
        RSimpleHolder rSimpleHolder = new RSimpleHolder(view);
        return rSimpleHolder;
    }
    /**
     * 设置每个条目的数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RSimpleHolder holder, final int position) {
        //重新定义textView的高度
        //获取textView再整个布局中的布局参数
        ViewGroup.LayoutParams layoutParams = holder.tv_item.getLayoutParams();
        layoutParams.height=heightList.get(position);
        //重新设置
        holder.tv_item.setLayoutParams(layoutParams);
        //对某一个控件设置点击事件
        holder.tv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener!=null){
                    //触发回调
                    onItemClickListener.onItemClick(position);
                }
            }
        });
        //设置长按事件
        holder.tv_item.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(onItemClickListener!=null){
                    //触发回调
                    onItemClickListener.onItemLongClick(position);
                }
                return true;
            }
        });
        holder.tv_item.setText(dataList.get(position));
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void onMove(int oldPosition, int newPosition) {
        //交换数据
        Collections.swap(dataList,oldPosition,newPosition);
        //刷新适配器--
        this.notifyItemMoved(oldPosition,newPosition);
    }

    public void onDelete(int adapterPosition) {
        dataList.remove(adapterPosition);
        this.notifyItemRemoved(adapterPosition);
    }
}
