package com.yfz.main.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yfz.main.R;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    private List mList = new ArrayList();
    private Context mContext = null;

    public MyAdapter(Context context, List list){
        this.mList = list;
        this.mContext = context;
    }
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(mContext).inflate(R.layout.tag_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {
        holder.vEditText.setText(mList.get(position).toString());
    }

    //返回列表最大数量
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //管理item的视图的holder
    class MyHolder extends RecyclerView.ViewHolder {
        TextView vEditText;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            vEditText = itemView.findViewById(R.id.vEditText);
        }
    }
    public List getList(){
        return mList;
    }

}
