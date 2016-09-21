package com.example.administrator.liwushuo.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeHeaderAdapter extends PagerAdapter {
    private List<View> data;

    public HomeHeaderAdapter(List<View> data) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }

    }

    @Override
    public int getCount() {
        if (data.size() != 0) {
            return 100000;
        }else {
            return 0;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

        container.removeView(data.get(position%data.size()));
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        int tranPosition = position%data.size();
        ViewParent parent = data.get(tranPosition).getParent();
        if (parent != null) {
            ViewGroup group = (ViewGroup) parent;
            group.removeView(data.get(tranPosition));
        }
        container.addView(data.get(tranPosition));
        return data.get(tranPosition);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}
