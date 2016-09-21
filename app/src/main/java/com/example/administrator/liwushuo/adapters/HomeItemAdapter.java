package com.example.administrator.liwushuo.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.homemodel.ItemsBean;
import com.squareup.picasso.Picasso;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeItemAdapter extends BaseAdapter {
    private static final String TAG = HomeItemAdapter.class.getSimpleName();
    private List<ItemsBean> data;
    private LayoutInflater inflater;
    private Context mContext;
    ImageOptions.Builder options = new ImageOptions.Builder();
    public HomeItemAdapter(List<ItemsBean> data, Context context) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void upData(List<ItemsBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();

        }
    }
    public void addRes(List<ItemsBean> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data != null ? data.size():0;
    }

    @Override
    public ItemsBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh  = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.home_fragment_listview_item,parent,false);
            vh = new ViewHolder();
            vh.tv1 = (TextView) convertView.findViewById(R.id.home_fragment_item_category);
            vh.tv2 = (TextView) convertView.findViewById(R.id.home_fragment_item_column_title);
            vh.tv3 = (TextView) convertView.findViewById(R.id.home_fragment_item_name);
            vh.tv4 = (TextView) convertView.findViewById(R.id.home_fragment_item_title);
            vh.tv5 = (TextView) convertView.findViewById(R.id.home_fragment_item_likes);
            vh.iv1 = (ImageView) convertView.findViewById(R.id.home_fragment_item_portrait);
            vh.iv2 = (ImageView) convertView.findViewById(R.id.home_fragment_item_picture);
            vh.tv6 = (TextView) convertView.findViewById(R.id.home_listview_item_up);
            vh.tv7 = (TextView) convertView.findViewById(R.id.home_listview_item_down);
            vh.time = (LinearLayout) convertView.findViewById(R.id.home_listview_item_time);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }


        if (getItem(position).getColumn()!=null) {
            vh.tv1.setText(getItem(position).getColumn().getCategory());
            vh.tv1.setBackgroundColor(Color.parseColor("#f98dd1"));
        }else {
            vh.tv1.setText("");
            vh.tv1.setBackgroundColor(Color.WHITE);
        }
        if (getItem(position).getColumn()!=null) {
            vh.tv2.setText(getItem(position).getColumn().getTitle());
        }else {
            vh.tv2.setText("");
        }
        if (getItem(position).getAuthor().getNickname()!=null) {
            vh.tv3.setText(getItem(position).getAuthor().getNickname());
        }else {
            vh.tv3.setText("");
        }
        if (getItem(position).getTitle()!=null) {
            vh.tv4.setText(getItem(position).getTitle());
        }else {
            vh.tv4.setText("");
        }
//        vh.tv5.setText(getItem(position).getLikes_count());
        options.setFadeIn(true).setCircular(true)
                .setLoadingDrawableId(R.mipmap.icon_picblank);
        x.image().bind(vh.iv1,getItem(position).getAuthor().getAvatar_url(), options.build());
        Picasso.with(mContext).load(getItem(position).getCover_image_url())
                .placeholder(R.mipmap.image_default).error(R.mipmap.icon_picblank)
                .into(vh.iv2);
        int updated_at = getItem(position).getUpdated_at();

        return convertView;
    }
    class ViewHolder{
        //分类
        TextView tv1;
        //column的题目
        TextView tv2;
        //昵称
        TextView tv3;
        //头像
        ImageView iv1;
        //图片
        ImageView iv2;
        //标题
        TextView tv4;
        //收藏人数
        TextView tv5;
        //时间条
        LinearLayout time;
        //时间条上部分
        TextView tv6;
        //时间条下部分
        TextView tv7;
    }
}
