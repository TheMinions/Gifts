package com.example.administrator.liwushuo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.TabModel;
import com.example.administrator.liwushuo.ui.fragments.homefragments.HomeItemFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class HomeFragment extends BaseFragment {
    public static final String TAG = HomeFragment.class.getSimpleName();
    private EditText mSearch;
    private ImageView mSignin;
    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private HomeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home,container,false);
        initView();
        setupView();
        return layout;
    }

    private void initView() {
        mSearch = ((EditText) layout.findViewById(R.id.home_search));
        mSignin = ((ImageView) layout.findViewById(R.id.home_signin));
        mTablayout = ((TabLayout) layout.findViewById(R.id.home_tablayout));
        mViewPager = ((ViewPager) layout.findViewById(R.id.home_viewpager));

        mAdapter = new HomeAdapter(getChildFragmentManager(),null);
        mViewPager.setAdapter(mAdapter);
    }

    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_TABLAYOUT);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                TabModel tabModel = gson.fromJson(result, TabModel.class);
                List<TabModel.DataBean.ChannelsBean> titles = tabModel.getData().getChannels();
                mAdapter.setTitles(titles);
                int size = titles.size();
                List<Fragment> data = new ArrayList<Fragment>();
                for (int i = 0; i < size; i++) {
                    HomeItemFragment fragment = new HomeItemFragment();
                    Bundle args = new Bundle();
                    args.putInt("id",titles.get(i).getId());
                    fragment.setArguments(args);
                    data.add(fragment);
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
