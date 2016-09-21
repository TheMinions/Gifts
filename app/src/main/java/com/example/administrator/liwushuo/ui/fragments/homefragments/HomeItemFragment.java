package com.example.administrator.liwushuo.ui.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeItemAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.HomeList;
import com.example.administrator.liwushuo.model.homemodel.ItemsBean;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeItemFragment extends BaseFragment implements PullToRefreshListView.OnRefreshListener2, AdapterView.OnItemClickListener {

    private static final String TAG = HomeItemFragment.class.getSimpleName();
    private PullToRefreshListView mPullToRefresh;
    private int id;
    private HomeItemAdapter mAdapter;
    private ListView mListView;
    private int offSet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.home_fragment_item_one,container,false);
        Bundle bundle = getArguments();
        id = bundle.getInt("id");
        initView();
        setupView(State.DOWM);
        return layout;
        //测试：
//        View inflate = inflater.inflate(R.layout.home_fragment_iten_test, container, false);
//        TextView id1 = (TextView) inflate.findViewById(R.id.home_fragment_item_id);
//        id1.setText(String.valueOf(id));
//        return inflate;
    }

    private void initView() {
        mPullToRefresh = ((PullToRefreshListView) layout.findViewById(R.id.home_fragment_listview));
        mListView = mPullToRefresh.getRefreshableView();
        mAdapter = new HomeItemAdapter(null,getActivity());
        mPullToRefresh.setMode(PullToRefreshBase.Mode.BOTH);
        mPullToRefresh.setOnRefreshListener(this);
        mPullToRefresh.setOnItemClickListener(this);
        mPullToRefresh.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
                mPullToRefresh.onRefreshComplete();
            }
        });

    }

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
