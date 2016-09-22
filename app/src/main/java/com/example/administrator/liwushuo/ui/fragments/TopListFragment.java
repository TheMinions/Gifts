package com.example.administrator.liwushuo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.TopListAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.toplistmodel.TopListTab;
import com.example.administrator.liwushuo.ui.fragments.toplistfragments.TopListItemFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class TopListFragment  extends BaseFragment{
    public static final String TAG = TopListFragment.class.getSimpleName();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mShare;
    private TopListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_toplist,container,false);
        initView();
        setupView();
        return layout;
    }

    private void initView() {
        mTabLayout = ((TabLayout) layout.findViewById(R.id.toplist_tl));
        mViewPager = ((ViewPager) layout.findViewById(R.id.toplist_viewpager));
        mShare = ((ImageView) layout.findViewById(R.id.toplist_share));
        //创建适配器
        mAdapter = new TopListAdapter(getChildFragmentManager(),null);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }
    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpConstant.TOPLIST_TAB);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                TopListTab topListTab = gson.fromJson(result, TopListTab.class);
                List<TopListTab.DataBean.RanksBean> tabRanks = topListTab.getData().getRanks();
                mAdapter.setTitles(tabRanks);
                List<Fragment> data = new ArrayList<Fragment>();
                for (int i = 0; i < tabRanks.size(); i++) {
                    TopListItemFragment itemFragment = new TopListItemFragment();
                    Bundle args = new Bundle();
                    args.putString("id",String.valueOf(tabRanks.get(i).getId()));
                    itemFragment.setArguments(args);
                    data.add(itemFragment);
                }
                mAdapter.upData(data);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }
            @Override
            public void onCancelled(CancelledException cex) {

            }
            @Override
            public void onFinished() {

            }
        });
    }
}
