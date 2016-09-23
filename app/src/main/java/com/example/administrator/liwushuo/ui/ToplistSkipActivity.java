package com.example.administrator.liwushuo.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.ecloud.pulltozoomview.PullToZoomListViewEx;
import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.TopListSkipFragmentAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.toplistmodel.TopSkipSingle;
import com.example.administrator.liwushuo.ui.fragments.toplistfragments.TopListSkipFragmentOne;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class ToplistSkipActivity extends AppCompatActivity {

    private PullToZoomListViewEx mPullZoom;
    private LayoutInflater mInflater = LayoutInflater.from(this);
    private ViewPager mViewPager;
    private ImageView mBack;
    private TabLayout mTabLayout;
    private String mId;
    private TopListSkipFragmentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toplist_skip);
        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.toplist_skip_zoom_viewpager);
        mBack = (ImageView) findViewById(R.id.toplist_skip_zoom_back);
        mTabLayout = (TabLayout) findViewById(R.id.toplist_skip_zoom_tablayout);
        List<Fragment> data = new ArrayList<>();
        TopListSkipFragmentOne fragmentOne = new TopListSkipFragmentOne();
        Bundle args = new Bundle();
        args.putString("mId","mId");
        fragmentOne.setArguments(args);
        data.add(fragmentOne);
        mAdapter = new TopListSkipFragmentAdapter(getSupportFragmentManager(),data);
    }


}
