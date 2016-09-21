package com.example.administrator.liwushuo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.administrator.liwushuo.model.homemodel.TabModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeAdapter extends FragmentPagerAdapter {

    private static final String TAG = HomeAdapter.class.getSimpleName();
    private List<Fragment> data;
    private List<TabModel.DataBean.ChannelsBean>  titles =new ArrayList<>();

    public HomeAdapter(FragmentManager fm , List<Fragment> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
    }
    public void setTitles(List<TabModel.DataBean.ChannelsBean> titles){
        if (titles != null) {
            this.titles.addAll(titles);

        }
    }
    public void upData(List<Fragment> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();

        }
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null? data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null) {
            return titles.get(position).getName();
        }
        return super.getPageTitle(position);
    }
}
