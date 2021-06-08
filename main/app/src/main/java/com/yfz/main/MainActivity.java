package com.yfz.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.yfz.main.widget.MyAdapter;
import com.yfz.main.widget.MyItemTouchHelperCallBack;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //RecycleView布局
    private RecyclerView vRecycleView;
    //GridLayoutManager管理网格状的视图位置
    private GridLayoutManager mGridLayoutManager;
    //RecycleViewAdapter适配器
    private MyAdapter mMyAdapter;
    //数据列表
    private List mList = new ArrayList();
    //TouchHelp位置布局中的item
    private ItemTouchHelper mItemTouchHelper;
    //网格状column数量
    private final int MAX_COLUMN = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
    }
    private void initialView(){
        mList.add("0");
        for(int i=1; i<=20; i++){
            mList.add(""+i);
        }
        vRecycleView = findViewById(R.id.vRecycleView);
        mGridLayoutManager = new GridLayoutManager(this,MAX_COLUMN);
        mMyAdapter = new MyAdapter(this,mList);
        mItemTouchHelper = new ItemTouchHelper(new MyItemTouchHelperCallBack());
        vRecycleView.setAdapter(mMyAdapter);
        vRecycleView.setLayoutManager(mGridLayoutManager);
        mItemTouchHelper.attachToRecyclerView(vRecycleView);
    }
}