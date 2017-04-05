package com.example.lining.recycler_my.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import com.example.lining.recycler_my.adapter.RWaterWallAdapter;


/**
 * Created by zhiyuan on 17/3/21.
 */

public class ItemTouchCallBack extends ItemTouchHelper.Callback {
    private RWaterWallAdapter waterWallAdapter;

    //获取滑动的标记
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //拖动改变位置标记
        int dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP|ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        //滑动删除的标记
        int swipeFlag = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    /**
     * 交换位置--移动
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //移动的时候

        int oldPosition = viewHolder.getAdapterPosition();
        int newPosition = target.getAdapterPosition();
        //交换位置-交换集合，刷新适配器
        waterWallAdapter.onMove(oldPosition,newPosition);
        return true;
    }
    //设置adapter
    public void setAdapter(RWaterWallAdapter waterWallAdapter){
        this.waterWallAdapter=waterWallAdapter;
    }

    /**
     * 删除
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //移除
        waterWallAdapter.onDelete(viewHolder.getAdapterPosition());
    }
}
