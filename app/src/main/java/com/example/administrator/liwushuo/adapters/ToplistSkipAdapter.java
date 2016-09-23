package com.example.administrator.liwushuo.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.toplistmodel.TopSkipSingle;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class ToplistSkipAdapter extends BaseAdapter {

    private List<TopSkipSingle.DataBean.RecommendItemsBean> data;
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public TopSkipSingle.DataBean.RecommendItemsBean getItem(int position) {
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
            convertView = inflater.inflate(R.layout.toplist_skip_zoom_one_item,parent,false);
            vh = new ViewHolder();
            vh.iv1 = (ImageView) convertView.findViewById(R.id.zoom_one_item_img1);
            vh.iv2 = (ImageView) convertView.findViewById(R.id.zoom_one_item_img2);
            vh.tv1 = (TextView) convertView.findViewById(R.id.zoom_one_item_title1);
            vh.tv2 = (TextView) convertView.findViewById(R.id.zoom_one_item_title2);
            vh.tv3 = (TextView) convertView.findViewById(R.id.zoom_one_item_price1);
            vh.tv4 = (TextView) convertView.findViewById(R.id.zoom_one_item_price2);
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }



        return convertView;
    }
    class ViewHolder{
        ImageView iv1;
        ImageView iv2;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;



    }
}
