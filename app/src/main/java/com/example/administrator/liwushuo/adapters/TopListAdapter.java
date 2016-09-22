package com.example.administrator.liwushuo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.liwushuo.model.toplistmodel.TopListTab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class TopListAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;
    private List<TopListTab.DataBean.RanksBean> titles;

    public TopListAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
    }

    public void setTitles(List<TopListTab.DataBean.RanksBean> titles) {
        this.titles = titles;
    }

    public void upData(List<Fragment> data){
        if (data!=null) {
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
        return data !=null? data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles.get(position).getName();
    }
}
