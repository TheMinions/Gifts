package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.classifymodel.StrtegyHead;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class ClassifyHeadStrtegyAdapter extends RecyclerView.Adapter<ClassifyHeadStrtegyAdapter.MyViewHoder> {
private List<StrtegyHead.DataEntity.ColumnsEntity>mData;
    private LayoutInflater inflater;
    private Context mContext;
    private View.OnClickListener listener;
    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener ;
    }
    public ClassifyHeadStrtegyAdapter(Context context , List<StrtegyHead.DataEntity.ColumnsEntity> data){
        this.mContext = context;
        this.mData = data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mData!=null?mData.size():0;
    }
    @Override
    public MyViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = inflater.inflate(R.layout.classify_strtegy_head_item, parent, false);

        return new MyViewHoder(viewItem);
    }

    @Override
    public void onBindViewHolder(MyViewHoder holder, int position) {
       holder.textViewtitle.setText(mData.get(position).getTitle());
        holder.textViewSubtitle.setText(mData.get(position).getSubtitle());
        holder.textViewAuthor.setText(mData.get(position).getAuthor());
        Picasso.with(mContext).load(mData.get(position).getBanner_image_url()).into(holder.imageView);
        if (listener!=null) {
            holder.imageView.setTag(position);
            holder.imageView.setOnClickListener(listener);
        }
    }

    public static class MyViewHoder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textViewtitle,textViewSubtitle,textViewAuthor;
        public MyViewHoder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_viewpager_pic);
            textViewtitle = (TextView) itemView.findViewById(R.id.tv_viewpager_title);
            textViewSubtitle = (TextView) itemView.findViewById(R.id.tv_viewpager_subtitle);
            textViewAuthor = (TextView) itemView.findViewById(R.id.tv_viewpager_author);
        }
    }
}
