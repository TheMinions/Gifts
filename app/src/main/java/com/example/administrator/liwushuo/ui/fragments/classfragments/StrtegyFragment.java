package com.example.administrator.liwushuo.ui.fragments.classfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.ClassifyEdnStrtegyAdapter;
import com.example.administrator.liwushuo.adapters.ClassifyHeadStrtegyAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.classifymodel.StrtegyEndList;
import com.example.administrator.liwushuo.model.classifymodel.StrtegyHead;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui on 2016/9/20.
 * 攻略
 */
public class StrtegyFragment extends BaseFragment {
    private RecyclerView mHeadRecyclerView;
    private List<StrtegyHead.DataEntity.ColumnsEntity> mData;
    private ClassifyHeadStrtegyAdapter mStrtegyAdapterHead;

    private RecyclerView mEndRecyclerView;
    private LinearLayoutManager mEndLinearLayoutManager;
    private List<StrtegyEndList.DataEntity.ChannelGroupsEntity> mBottomData;
    private ClassifyEdnStrtegyAdapter mClassifyEdnStrtegyAdapter;
    private GridLayoutManager mHeadGridLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_classify_strtegy, container, false);
        initView(layout);
        initData();
        setData();
        return layout;

    }

    //
    private void initView(View view) {
        //头布局
        mHeadRecyclerView = ((RecyclerView) layout.findViewById(R.id.fragment_strtegy_head_recyclerView));
        //头布局管理器
        mHeadGridLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.HORIZONTAL, false);

        //剩下布局
        mEndRecyclerView = ((RecyclerView) layout.findViewById(R.id.fragment_strtegy_end_recyclerView));
        //布局管理器
        mEndLinearLayoutManager = new LinearLayoutManager(getActivity());

    }

    private void initData() {
        //头布局
        mData = new ArrayList<>();
        mStrtegyAdapterHead = new ClassifyHeadStrtegyAdapter(getActivity(), mData);
        RequestParams requestParams = new RequestParams(HttpConstant.CLASSIFY_STRTEGY_HEAD);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    Gson gson = new Gson();
                    StrtegyHead strtegyHead = gson.fromJson(result, StrtegyHead.class);
                    List<StrtegyHead.DataEntity.ColumnsEntity> columns = strtegyHead.getData().getColumns();
                    mData.addAll(columns);
                    mStrtegyAdapterHead.setOnclickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position = (int) v.getTag();
                            int id = mData.get(position).getId();

                        }
                    });
                    //适配器刷新
                    mStrtegyAdapterHead.notifyDataSetChanged();
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

            }
        });

        mBottomData = new ArrayList<>();
        mClassifyEdnStrtegyAdapter = new ClassifyEdnStrtegyAdapter(getActivity(), mBottomData);
        RequestParams params = new RequestParams(HttpConstant.CLASSIFY_STRTEGY_END);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    Gson gson = new Gson();
                    StrtegyEndList strtegyEndList = gson.fromJson(result, StrtegyEndList.class);
                    List<StrtegyEndList.DataEntity.ChannelGroupsEntity> channel_groups = strtegyEndList.getData().getChannel_groups();
                    mBottomData.addAll(channel_groups);
                    //
                    mClassifyEdnStrtegyAdapter.notifyDataSetChanged();
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

            }
        });

    }


    private void setData() {
        mHeadRecyclerView.setLayoutManager(mHeadGridLayoutManager);
        mHeadRecyclerView.setAdapter(mStrtegyAdapterHead);

        mEndRecyclerView.setLayoutManager(mEndLinearLayoutManager);
        mEndRecyclerView.setAdapter(mClassifyEdnStrtegyAdapter);

    }
}
