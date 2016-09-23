package com.example.administrator.liwushuo.ui.fragments.toplistfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecloud.pulltozoomview.PullToZoomListViewEx;
import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.ToplistSkipAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.toplistmodel.TopSkipSingle;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class TopListSkipFragmentOne extends BaseFragment {

    private PullToZoomListViewEx mPullZoom;
    private LayoutInflater mInflater;
    private View mZoomView;
    private String mId;
    private ToplistSkipAdapter mToplistSkipAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_toplist_skip_zoom_one,container,false);
        mInflater = inflater;
        mZoomView = inflater.inflate(R.layout.toplist_skip_zoom_pic,container,false);
        Bundle bundle = getArguments();
        mId = bundle.getString("mId");
        initView();
        setupView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView() {

        mPullZoom = ((PullToZoomListViewEx) layout.findViewById(R.id.fragment_list_skip_pullzoom));
        mPullZoom.setHideHeader(true);
        mPullZoom.setZoomView(mZoomView);
        mPullZoom.setZoomEnabled(true);
        //创建适配器
        mToplistSkipAdapter = new ToplistSkipAdapter(null,getActivity());
    }
    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpConstant.TOPLIST_SKIP_SINGLE+mId+"/recommend?num=20&post_num=5");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                TopSkipSingle topSkipSingle = gson.fromJson(result, TopSkipSingle.class);
                List<TopSkipSingle.DataBean.RecommendItemsBean> data = topSkipSingle.getData().getRecommend_items();
                mToplistSkipAdapter.upData(data);
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
