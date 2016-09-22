package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.classifymodel.OneBrandList;

import java.util.List;

/**
 * Created by liuhui on 2016/9/21.
 */
public class OneBrandLeftAdapter extends BaseAdapter {
    private List<OneBrandList.DataBean.CategoriesBean> mData;
    private LayoutInflater inflater;
    private View mLastCheckedView = null;
    private int mCheckedPosition = -1;

    public OneBrandLeftAdapter(Context context, List<OneBrandList.DataBean.CategoriesBean> data) {
        this.mData = data;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.onbrand_left_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //判断当前的position是否和position相同 获取该位置是否为选中的位置
        setViewSelected(convertView, mCheckedPosition == position);
        //设置数据
        holder.mTitle.setText(mData.get(position).getName());

        return convertView;
    }

    //设置被选中的一项
    public void setCheckedPosition(int position) {
        mCheckedPosition = position;
        notifyDataSetChanged();
    }

    public void setCheckedView(View checkedView) {
        /**
         * 一种特殊情况是，ListView里面的个数超出当前屏幕的话，
         * 当我们滑动ListView的时候，ListView是会复用我们之前已经创建过的View的，
         *  所以，我们必须对选中的Item做一个特殊处理。被选中的Item，如果滑出屏幕，
         * 其对应的View是会被复用的，所以必须在其被复用的时候，将其置为未选中状态
         * 而当其重新滑入屏幕的时候，将其置为选中状态
         *
         */
        setViewSelected(mLastCheckedView, false);
        //item的布局是linearLayout
        RelativeLayout linearlayout = (RelativeLayout) checkedView;
        setViewSelected(linearlayout, true);
    }

    //设置选中时字体颜色及赋值
    public void setViewSelected(View view, boolean selected) {
        if (view != null) {
            ViewHolder viewHolder = (ViewHolder) view.getTag();
            if (viewHolder != null) {
                if (selected) {//被选中时
                    viewHolder.mTitle.setTextColor(Color.RED);

                    mLastCheckedView = view;
                }else {
                    viewHolder.mTitle.setTextColor(Color.BLACK);
                }
            }
        }
    }

    public static class ViewHolder {
        private TextView mTitle;

        public ViewHolder(View view) {
            mTitle = (TextView) view.findViewById(R.id.onbrand_left_title);
        }
    }
}
