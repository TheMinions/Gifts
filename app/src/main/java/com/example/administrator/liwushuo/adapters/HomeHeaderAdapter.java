package com.example.administrator.liwushuo.adapters;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/21 0021.
 */
public class HomeHeaderAdapter extends PagerAdapter {
    private static final String TAG = HomeHeaderAdapter.class.getSimpleName();
    private List<View> data;

    public HomeHeaderAdapter(List<View> data) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }

    }

    public void upData(List<View> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
            Log.e(TAG, "upData: "+this.data.size() );
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

    public int getRealCount(){

        return data.size();
    }

    @Override
    public int getItemPosition(Object object) {

        return super.getItemPosition(object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    /**
     * 销毁
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        int tranPosition = position % data.size();
        container.removeView(data.get(tranPosition));
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
