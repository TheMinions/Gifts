package com.example.administrator.liwushuo.ui.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeItemAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.HomeHeaderOne;
import com.example.administrator.liwushuo.model.homemodel.HomeHeaderTwo;
import com.example.administrator.liwushuo.model.homemodel.HomeList;
import com.example.administrator.liwushuo.model.homemodel.ItemsBean;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.example.administrator.liwushuo.view.CircleIndicator;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 *
 */
public class HomeItemFragmentOne extends BaseFragment implements PullToRefreshListView.OnRefreshListener2{

    private static final String TAG = HomeItemFragmentOne.class.getSimpleName();
    private PullToRefreshListView mPullToRefresh;
    private int id;
    private HomeItemAdapter mAdapter;
    private ListView mListView;
    private int offSet;
    private LayoutInflater inflater;
    private ViewPager mHeadViewPager;
    private LinearLayout mScrollContainer;
    private CircleIndicator circleIndicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.home_fragment_item_one,container,false);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        this.inflater = inflater;
        initView();
        setupHeader(State.DOWM);
        setupView(State.DOWM);
        return layout;
    }

    private void setupHeader(State state) {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_VIEWPAGER);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                HomeHeaderOne homeHeaderOne = gson.fromJson(result, HomeHeaderOne.class);


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
        RequestParams requestParams1 = new RequestParams();
        x.http().get(requestParams1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                HomeHeaderTwo headerTwo = gson.fromJson(result, HomeHeaderTwo.class);
                int size = headerTwo.getData().getSecondary_banners().size();
                for (int i = 0; i < size; i++) {
                    View inflate = inflater.inflate(R.layout.home_header_item_two, null);
                    ImageView pictuer = (ImageView) inflate.findViewById(R.id.home_header_item_picture2);
                    Picasso.with(HomeItemFragmentOne.this.getActivity()).load(headerTwo.getData().getSecondary_banners().get(i).getImage_url()).placeholder(R.mipmap.image_default).into(pictuer);
                    mScrollContainer.addView(inflate);
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

    private void initView() {
        mPullToRefresh = ((PullToRefreshListView) layout.findViewById(R.id.home_fragment_listview));
        mListView = mPullToRefresh.getRefreshableView();
        mAdapter = new HomeItemAdapter(null,getActivity());
        mPullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefresh.setOnRefreshListener(this);
        //头布局
        View header = inflater.inflate(R.layout.home_fragment_item_one_header, null);
        mHeadViewPager = ((ViewPager) header.findViewById(R.id.home_fragment_item_header_viewpage));
        mScrollContainer = (LinearLayout) header.findViewById(R.id.home_fragment_item_header_container);
        //头布局的适配器


        //小圆点导航的自定义view
        circleIndicator = (CircleIndicator)header.findViewById(R.id.indicator);
        //设置小圆点导航
        circleIndicator.setViewPager(mHeadViewPager);
        mPullToRefresh.setAdapter(mAdapter);
    }
    enum State{
        UP,DOWM
    }
    private void setupView(final State state) {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_FRAGMENT+id+"/items_v2?ad=2&gender=1&generation=2&limit=20&offset="+offSet);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeList homeList = gson.fromJson(result, HomeList.class);
                List<ItemsBean> data = homeList.getData().getItems();
                if (state == State.DOWM) {
                    mAdapter.upData(data);
                    mPullToRefresh.onRefreshComplete();
                }else {
                    mAdapter.addRes(data);
                    mPullToRefresh.onRefreshComplete();
                }
                Log.e(TAG, "onSuccess: " );
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " );
                mPullToRefresh.onRefreshComplete();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    //*************************************************
    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        offSet = 0 ;
        setupView(State.DOWM);
        mPullToRefresh.onRefreshComplete();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        offSet += 20;
        setupView(State.UP);
        mPullToRefresh.onRefreshComplete();
    }
}
