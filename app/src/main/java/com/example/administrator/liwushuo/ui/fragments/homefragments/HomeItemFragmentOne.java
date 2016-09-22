package com.example.administrator.liwushuo.ui.fragments.homefragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeHeaderAdapter;
import com.example.administrator.liwushuo.adapters.HomeItemAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.HomeHeaderOne;
import com.example.administrator.liwushuo.model.homemodel.HomeHeaderTwo;
import com.example.administrator.liwushuo.model.homemodel.HomeList;
import com.example.administrator.liwushuo.model.homemodel.ItemsBean;
import com.example.administrator.liwushuo.ui.HomeRaidersActivity;
import com.example.administrator.liwushuo.ui.ListBottomActivity;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.example.administrator.liwushuo.view.CircleIndicator;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.squareup.picasso.Picasso;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeItemFragmentOne extends BaseFragment implements PullToRefreshListView.OnRefreshListener2, ViewPager.OnPageChangeListener ,Handler.Callback, AdapterView.OnItemClickListener, View.OnClickListener {

    private static final String TAG = HomeItemFragmentOne.class.getSimpleName();
    private static final int MOVE = 100;
    private static final long MOVE_DELAY = 5 * 1000;
    private PullToRefreshListView mPullToRefresh;
    private int id;
    private HomeItemAdapter mAdapter;
    private ListView mListView;
    private int offSet;
    private LayoutInflater inflater;
    private ViewPager mHeadViewPager;
    private LinearLayout mScrollContainer;
    private CircleIndicator circleIndicator;
    private HomeHeaderAdapter mHeaderAdapter;
    private int currentPage = 400;
    private Handler mHandler;
    private View mHeader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.home_fragment_item_one,container,false);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        this.inflater = inflater;
        initView();
        setupHeader();
        setupView(State.DOWM);
        return layout;
    }

    private void setupHeader() {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_VIEWPAGER);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                HomeHeaderOne homeHeaderOne = gson.fromJson(result, HomeHeaderOne.class);
                int size = homeHeaderOne.getData().getBanners().size();
                List<View> data=new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    String image_url = homeHeaderOne.getData().getBanners().get(i).getImage_url();
                    View view = inflater.inflate(R.layout.home_header_item_one, null);
                    ImageView picture = (ImageView) view.findViewById(R.id.home_header_item_picture);
                    picture.setTag(R.id.header_one,homeHeaderOne.getData().getBanners().get(i));
                    picture.setOnClickListener(HomeItemFragmentOne.this);
                    Picasso.with(HomeItemFragmentOne.this.getActivity()).load(image_url).placeholder(R.mipmap.image_default).into(picture);
                    data.add(view);
                    Log.e(TAG, "onSuccess: "+"\t"+size);
                }
                mHeaderAdapter.upData(data);
                mHeadViewPager.setCurrentItem(currentPage);
                if (!mHandler.hasMessages(MOVE)) {
                    mHandler.sendEmptyMessage(MOVE);
                }
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: " +ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        RequestParams requestParams1 = new RequestParams(HttpConstant.HOME_SCROLL);
        x.http().get(requestParams1, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                HomeHeaderTwo headerTwo = gson.fromJson(result, HomeHeaderTwo.class);
                int size = headerTwo.getData().getSecondary_banners().size();
                for (int i = 0; i < size; i++) {
                    View inflate = inflater.inflate(R.layout.home_header_item_two, null);
                    ImageView pictuer = (ImageView) inflate.findViewById(R.id.home_header_item_picture2);
                    pictuer.setTag(R.id.header_two,headerTwo.getData().getSecondary_banners().get(i).getTarget_url());
                    pictuer.setOnClickListener(HomeItemFragmentOne.this);
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
        mAdapter = new HomeItemAdapter(null,getActivity(),true);
        mPullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefresh.setOnRefreshListener(this);
        //头布局
        mHeader = inflater.inflate(R.layout.home_fragment_item_one_header, null);
        mHeadViewPager = ((ViewPager) mHeader.findViewById(R.id.home_fragment_item_header_viewpage));
        mHeadViewPager.addOnPageChangeListener(this);
        mScrollContainer = (LinearLayout) mHeader.findViewById(R.id.home_fragment_item_header_container);
        //头布局的适配器
        mHeaderAdapter = new HomeHeaderAdapter(null);
        mHeadViewPager.setAdapter(mHeaderAdapter);
        mListView.addHeaderView(mHeader);
        //小圆点导航的自定义view
        circleIndicator = (CircleIndicator)mHeader.findViewById(R.id.indicator);
        //设置小圆点导航
        circleIndicator.setViewPager(mHeadViewPager);
        mPullToRefresh.setAdapter(mAdapter);
        mPullToRefresh.setOnItemClickListener(this);
        mHandler = new Handler(this);
    }
    //***********************头布局viewpager改变的监听****************************
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ItemsBean itemsBean = (ItemsBean) parent.getItemAtPosition(position);
        String url = itemsBean.getUrl();
        Intent intent = new Intent(getActivity(), HomeRaidersActivity.class);
        intent.putExtra("web",url);
        getActivity().startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        HomeHeaderOne.DataBean.BannersBean tag1 = (HomeHeaderOne.DataBean.BannersBean) v.getTag(R.id.header_one);
        String tag2 = (String) v.getTag(R.id.header_two);
        if (tag1 != null) {
            if (tag1.getTarget()==null) {
                Toast.makeText(HomeItemFragmentOne.this.getActivity(), "你点击的接口没抓到，木有啊！", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent();
//                intent.putExtra("web","");
//                startActivity(intent);
            }else {
                int id = tag1.getTarget().getId();
                Intent intent = new Intent(getActivity(), ListBottomActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        }else if(tag2 != null){
            Toast.makeText(HomeItemFragmentOne.this.getActivity(), "你点击的scrollview是第"+tag2+"张", Toast.LENGTH_SHORT).show();
            String[] split = tag2.split("=");
            if (split.length == 3) {
                String id = split[2];
                Intent intent = new Intent(getActivity(), ListBottomActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }else {
                Toast.makeText(HomeItemFragmentOne.this.getActivity(), "你点击的页面比较复杂，没做！！", Toast.LENGTH_SHORT).show();
            }
        }

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
                mPullToRefresh.onRefreshComplete();
            }
        });

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case MOVE:
                currentPage++;
                mHeadViewPager.setCurrentItem(currentPage);
                    mHandler.sendEmptyMessageDelayed(MOVE,MOVE_DELAY);
                break;
        }
        return false;
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
