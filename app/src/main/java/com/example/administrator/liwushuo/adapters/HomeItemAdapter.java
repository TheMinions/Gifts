package com.example.administrator.liwushuo.adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.homemodel.HomeList;
import com.squareup.picasso.Picasso;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeItemAdapter extends BaseAdapter {
    private List<HomeList.DataBean.ItemsBean> data;
    private LayoutInflater inflater;
    private Context mContext;

    public HomeItemAdapter(List<HomeList.DataBean.ItemsBean> data, Context context) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data != null ? data.size():0;
    }

    @Override
    public HomeList.DataBean.ItemsBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
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
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.tv1.setText(getItem(position).getColumn().getCategory());
        vh.tv2.setText(getItem(position).getColumn().getTitle());
        vh.tv3.setText(getItem(position).getAuthor().getNickname());
        vh.tv4.setText(getItem(position).getTitle());
        vh.tv5.setText(getItem(position).getLikes_count());
        ImageOptions.Builder options = new ImageOptions.Builder();
        options.setFadeIn(true).setCircular(true)
                .setLoadingDrawableId(R.mipmap.icon_picblank);
        x.image().bind(vh.iv1,getItem(position).getAuthor().getAvatar_url(), options.build());
        Picasso.with(mContext).load(getItem(position).getCover_image_url())
                .placeholder(R.mipmap.image_default).error(R.mipmap.icon_picblank)
                .into(vh.iv2);
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


    }
}
