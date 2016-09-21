package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.liwushuo.R;

import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class SeekAdapter extends RecyclerView.Adapter<SeekAdapter.MyViewHolder> {
    private List<String> data;
    private LayoutInflater inflater;
    private View.OnClickListener listener;

    public SeekAdapter(Context context,List<String> data){
        this.data=data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.seek_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
     holder.itemBtn.setText(data.get(position));
        //设置监听
        if (listener!=null) {
            holder.itemBtn.setTag(position);
            holder.itemBtn.setOnClickListener(listener);
        }
    }
public void setOnClickListener(View.OnClickListener listener){
    this.listener=listener;
}

    public class MyViewHolder extends RecyclerView.ViewHolder {
     Button itemBtn;
        public MyViewHolder(View itemView) {
            super(itemView);
           itemBtn= (Button) itemView.findViewById(R.id.seek_item_btn);
        }
    }

}
