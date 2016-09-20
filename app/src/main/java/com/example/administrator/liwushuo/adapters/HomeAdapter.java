package com.example.administrator.liwushuo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public HomeAdapter(FragmentManager fm , List<Fragment> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
