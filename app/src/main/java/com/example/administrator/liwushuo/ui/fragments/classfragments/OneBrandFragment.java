package com.example.administrator.liwushuo.ui.fragments.classfragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.OneBrandLeftAdapter;
import com.example.administrator.liwushuo.adapters.OneBrandRightAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.classifymodel.OneBrandList;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhui on 2016/9/20.
 * 单品
 */
public class OneBrandFragment extends BaseFragment {

    private ListView mLeftListView;
    private ListView mRightListView;
    private List<OneBrandList.DataBean.CategoriesBean> mData;
    private OneBrandLeftAdapter mOneBrandLeftAdapter;
    private OneBrandRightAdapter mOneBrandRightAdapter;
    private int mCurrentPosition = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_classify_onebrand, container, false);
        initView();
        initData();
        setData();
        setListener();
        return layout;

    }

    private void initView() {
        mLeftListView = ((ListView) layout.findViewById(R.id.fragment_onebrand_left_listView));
        mRightListView = ((ListView) layout.findViewById(R.id.fragment_onebrand_right_listView));

    }

    //请求数据
    private void initData() {
        mData = new ArrayList<>();
        //适配器实例化
        mOneBrandLeftAdapter = new OneBrandLeftAdapter(getActivity(), mData);
        mOneBrandRightAdapter = new OneBrandRightAdapter(getActivity(), mData);
        //
        RequestParams params = new RequestParams(HttpConstant.ONEBRAND);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                OneBrandList oneBrandList = gson.fromJson(result, OneBrandList.class);
                List<OneBrandList.DataBean.CategoriesBean> categories = oneBrandList.getData().getCategories();
                mData.addAll(categories);
                mOneBrandLeftAdapter.notifyDataSetChanged();
                mOneBrandRightAdapter.notifyDataSetChanged();

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
  //设置数据
    private void setData() {
        //设置进入时首选项
        mOneBrandLeftAdapter.setCheckedPosition(0);
        //绑定适配器
        mLeftListView.setAdapter(mOneBrandLeftAdapter);
        mRightListView.setAdapter(mOneBrandRightAdapter);
    }
   //设置监听
    private void setListener() {
        mLeftListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击左边和右边的联动
                mRightListView.setSelection(position);
                //设置被选中
                mOneBrandLeftAdapter.setCheckedPosition(position);
                mOneBrandLeftAdapter.setCheckedView(view);
                mCurrentPosition = position;

            }
        });
        //右边设置触摸监听
        mRightListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //左边展示
                mLeftListView.dispatchTouchEvent(event);
                return false;
            }
        });
        //右边滑动监听
        mRightListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==SCROLL_STATE_IDLE) {
                    if (mRightListView.getChildAt(0)!=null) {
                        //设置被选中项
                       mOneBrandLeftAdapter.setCheckedPosition(mCurrentPosition);
                       //用来存储成对出现的参数
                        Rect rect = new Rect();
                        //getChildVisibleRect获取视图在屏幕坐标中的可视区域
                        mRightListView.getChildVisibleRect(mRightListView.getChildAt(0),rect,null);
                       //设置ListView选中的位置，同时在Y轴设置一个偏移量
                        mLeftListView.setSelectionFromTop(mRightListView.getFirstVisiblePosition(),rect.top);

                    }
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
           mCurrentPosition=firstVisibleItem;


            }
        });
    }

}
