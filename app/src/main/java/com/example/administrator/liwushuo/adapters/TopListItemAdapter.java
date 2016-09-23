package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.toplistmodel.TopList;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class TopListItemAdapter extends RecyclerView.Adapter<TopListItemAdapter.ViewHolder> implements View.OnClickListener {
    private static final String TAG = TopListItemAdapter.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private TopList.DataBean data;
    private LayoutInflater inflater;
    private Context mContext;
    private PositionClickListener mListener;

    public TopListItemAdapter(TopList.DataBean data, Context context) {
        inflater = LayoutInflater.from(context);
        mContext = context;
        if (data != null) {
            this.data = data;
        }else {
            this.data = new TopList.DataBean();
        }

    }

    public void setListener(PositionClickListener listener) {
        mListener = listener;
    }

    public void upData(TopList.DataBean data){
        if (data != null) {
            this.data = null;
            this.data = data;
            notifyDataSetChanged();
        }
    }

    public void addRes(TopList.DataBean data){
        if (data != null) {
            this.data.getItems().addAll(data.getItems());
            notifyDataSetChanged();
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case 0:
                itemView = inflater.inflate(R.layout.toplist_item_recycle_item_one,parent,false);
                break;
            case 1:
                itemView = inflater.inflate(R.layout.toplist_item_recycle_item_two,parent,false);
                break;
        }
        itemView.setOnClickListener(this);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case 0:
                ImageView pic1 = (ImageView) holder.getView(R.id.toplist_item_recycle_item1_picture);
                Picasso.with(mContext).load(((String) getItem(position))).placeholder(R.mipmap.image_default)
                        .into(pic1);
                break;
            case 1:
                ImageView pic2 = (ImageView) holder.getView(R.id.toplist_item_recycle_item2_pic);
                TextView name = (TextView) holder.getView(R.id.toplist_item_recycle_item2_name);
                TextView content = (TextView) holder.getView(R.id.toplist_item_recycle_item2_content);
                TextView price = (TextView) holder.getView(R.id.toplist_item_recycle_item2_price);
                name.setText(((TopList.DataBean.ItemsBean) getItem(position)).getName());
                content.setText(((TopList.DataBean.ItemsBean) getItem(position)).getShort_description());
                price.setText("￥ "+((TopList.DataBean.ItemsBean) getItem(position)).getPrice());
                Log.e(TAG, "onBindViewHolder: "+((TopList.DataBean.ItemsBean) getItem(position)).getCover_image_url() );
                Picasso.with(mContext).load(((TopList.DataBean.ItemsBean) getItem(position)).getCover_image_url()).placeholder(R.mipmap.image_default)
                        .into(pic2);
                break;
        }

    }

    @Override
    public int getItemCount() {

        return data.getItems()!=null?(data.getItems().size()+1):0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }


    public Object getItem(int position) {
        if (position == 0) {
            return data.getCover_image();
        }
        return data.getItems().get(position-1);
    }

    @Override
    public void onClick(View v) {
        int position = mRecyclerView.getChildAdapterPosition(v);
        if (mListener != null) {
            RecyclerView.ItemAnimator animator = mRecyclerView.getItemAnimator();
            if (animator.isRunning()) {
                Toast.makeText(mContext, "正在动画，请稍后", Toast.LENGTH_SHORT).show();
                return;
            }
            mListener.getPosition(position);
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private Map<Integer , View> mCacherView;

        public ViewHolder(View itemView) {
            super(itemView);
            mCacherView = new HashMap<>();
        }

        public View getView(int resId){
            View view = null;
            if (mCacherView.containsKey(resId)) {
                view = mCacherView.get(resId);
            }else {
                view = itemView.findViewById(resId);
                mCacherView.put(resId,view);
            }
            return view;
        }

    }

    public interface PositionClickListener{
        void getPosition(int position);
    }

}
