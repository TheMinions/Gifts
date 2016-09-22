package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.classifymodel.OneBrandList;
import com.example.administrator.liwushuo.view.RewriterGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui on 2016/9/22.
 */
public class OneBrandRightAdapter extends BaseAdapter {
    private List<OneBrandList.DataBean.CategoriesBean> mData;
    private LayoutInflater inflater;
    private Context mContext;

    private OneBranRightGridViewAdapter mGridAdapter;
    private List<OneBrandList.DataBean.CategoriesBean.SubcategoriesBean> mDataGridView;

    public OneBrandRightAdapter(Context context, List<OneBrandList.DataBean.CategoriesBean> data) {
        this.mContext = context;
        this.mData = data;
        inflater = LayoutInflater.from(context);
        mDataGridView = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
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
        mDataGridView = mData.get(position).getSubcategories();
        mGridAdapter=new OneBranRightGridViewAdapter(mContext,mDataGridView);
        RightViewHolder holder = null;
        if (holder == null) {
            convertView = inflater.inflate(R.layout.onebrand_right_item, parent, false);
            holder = new RightViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (RightViewHolder) convertView.getTag();
        }
        holder.mGridView.setAdapter(mGridAdapter);
        if (position==0) {
            holder.mTextView.setVisibility(View.GONE);
        }else {
            holder.mTextView.setText(mData.get(position).getName());
        }
        return convertView;
    }

    public static class RightViewHolder {
        private RewriterGridView mGridView;
        private View viewOne, viewTwo;
        private TextView mTextView;

        public RightViewHolder(View view) {
            mGridView = (RewriterGridView) view.findViewById(R.id.onbrand_right_gridView);
            viewOne = view.findViewById(R.id.onbrand_right_line);
            viewTwo = view.findViewById(R.id.onbrand_right_line2);
            mTextView = (TextView) view.findViewById(R.id.onbrand_right_show);

        }
    }

}
