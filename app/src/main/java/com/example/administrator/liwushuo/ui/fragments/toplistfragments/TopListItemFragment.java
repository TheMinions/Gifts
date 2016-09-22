package com.example.administrator.liwushuo.ui.fragments.toplistfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.TopListItenAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.toplistmodel.TopList;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.example.administrator.liwushuo.view.PullToRefreshRecyclerView;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 *
 */
public class TopListItemFragment extends BaseFragment implements PullToRefreshRecyclerView.OnRefreshListener2{
    private String mId;
    private PullToRefreshRecyclerView mPullRecycle;
    private int offSet = 0;
    private TopListItenAdapter mTopListItenAdapter;
    private RecyclerView mRececleView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.toplist_fragment_item,container,false);
        Bundle bundle = getArguments();
        mId = bundle.getString("id");
        initView();
        setupView(State.DOWN);
        return layout;
    }

    private void initView() {
        mPullRecycle = ((PullToRefreshRecyclerView) layout.findViewById(R.id.toplist_item_recycle));
        mPullRecycle.setMode(PullToRefreshBase.Mode.BOTH);
        mPullRecycle.setOnRefreshListener(this);
        mRececleView = mPullRecycle.getRefreshableView();
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0){
                    return 2;
                }
                return 1;
            }
        });
        mRececleView.setLayoutManager(layoutManager);
        //创建适配器
        mTopListItenAdapter = new TopListItenAdapter(null,getActivity());
        mRececleView.setAdapter(mTopListItenAdapter);

    }

     private void setupView(final State state) {
         RequestParams requestParams = new RequestParams(HttpConstant.TOPLIST_FRAGMENT+mId+"?limit=20&offset="+offSet);
         x.http().get(requestParams, new Callback.CommonCallback<String>() {
             @Override
             public void onSuccess(String result) {
                 Gson gson=new Gson();
                 TopList topList = gson.fromJson(result, TopList.class);
                 if (state == State.DOWN) {
                     mTopListItenAdapter.upData(topList.getData());
                 }else if(state == State.UP){
                     mTopListItenAdapter.addRes(topList.getData());
                 }


             }

             @Override
             public void onError(Throwable ex, boolean isOnCallback) {

             }

             @Override
             public void onCancelled(CancelledException cex) {

             }

             @Override
             public void onFinished() {
                 mPullRecycle.onRefreshComplete();
             }
         });
    }
    enum State{
        DOWN,UP
    }
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        offSet=0;
        setupView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        offSet += 20;
        setupView(State.UP);
    }
}