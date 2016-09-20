package com.example.administrator.liwushuo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.liwushuo.R;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class HomeFragment extends BaseFragment {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private EditText mSearch;
    private ImageView mSignin;
    private TabLayout mTablayout;
    private ViewPager mViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home,container,false);
        initView();

        return layout;
    }

    private void initView() {
        mSearch = ((EditText) layout.findViewById(R.id.home_search));
        mSignin = ((ImageView) layout.findViewById(R.id.home_signin));
        mTablayout = ((TabLayout) layout.findViewById(R.id.home_tablayout));
        mViewPager = ((ViewPager) layout.findViewById(R.id.home_viewpager));


//        mViewPager.setAdapter();


    }


}
