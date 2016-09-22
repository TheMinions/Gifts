package com.example.administrator.liwushuo.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.model.classifymodel.OneBrandList;
import com.example.administrator.liwushuo.ui.OneBranRightDetailedActivity;

import org.xutils.x;

import java.util.List;

/**
 * Created by liuhui on 2016/9/22.
 */
public class OneBranRightGridViewAdapter extends BaseAdapter {
    private List<OneBrandList.DataBean.CategoriesBean.SubcategoriesBean> mDataGridView;
    private LayoutInflater inflater;
    private Context context;

    public OneBranRightGridViewAdapter(Context context, List<OneBrandList.DataBean.CategoriesBean.SubcategoriesBean> mDataGridView) {
        this.context = context;
        this.mDataGridView = mDataGridView;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mDataGridView != null ? mDataGridView.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mDataGridView.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GridViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.onebran_right_gridview_item, parent, false);
            holder = new GridViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (GridViewHolder) convertView.getTag();
        }
        //设置数据
        x.image().bind(holder.image, mDataGridView.get(position).getIcon_url());
        holder.title.setText(mDataGridView.get(position).getName());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OneBranRightDetailedActivity.class);
                intent.putExtra("id", mDataGridView.get(position).getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    public static class GridViewHolder {
        private ImageView image;
        private TextView title;

        public GridViewHolder(View itemView) {
            image = (ImageView) itemView.findViewById(R.id.gridview_item_image);
            title = (TextView) itemView.findViewById(R.id.gridview_item_title);
        }
    }
}
