package com.yfz.main.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

public class MyItemTouchHelperCallBack extends ItemTouchHelper.Callback {
    private  MyAdapter mMyAdapter;
    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int drawFlag = ItemTouchHelper.LEFT |ItemTouchHelper.UP |ItemTouchHelper.RIGHT |ItemTouchHelper.DOWN;
        int swipeFlag = 0;
        if(null == mMyAdapter){
            mMyAdapter = (MyAdapter) recyclerView.getAdapter();
        }
        return makeMovementFlags(drawFlag,swipeFlag);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int selectedPosition = viewHolder.getAdapterPosition();
        int movedPosition = target.getAdapterPosition();
        if(null != mMyAdapter){
            Collections.swap(mMyAdapter.getList(),selectedPosition,movedPosition);
            mMyAdapter.notifyItemMoved(selectedPosition,movedPosition);
        }
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
