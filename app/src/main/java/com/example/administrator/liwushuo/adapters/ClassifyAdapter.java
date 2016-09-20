package com.example.administrator.liwushuo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by liuhui on 2016/9/20.
 *
 */
public class ClassifyAdapter extends FragmentPagerAdapter{
private List<Fragment> mFragments;
    private List <String> mTitle;

    public ClassifyAdapter(FragmentManager fm,List<Fragment> fragments,List <String> title) {
        super(fm);
     mFragments=fragments;
        mTitle=title;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
