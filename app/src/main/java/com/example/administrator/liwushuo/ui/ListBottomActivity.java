package com.example.administrator.liwushuo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.ListBottomAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.ListBottom;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

public class ListBottomActivity extends BaseActivity implements PullToRefreshListView.OnRefreshListener2, View.OnClickListener {

    private static final String TAG = ListBottomActivity.class.getSimpleName();
    private PullToRefreshListView mPullListView;
    private ListBottomAdapter mAdapter;
    private int mId;
    private int offSet;
    private TextView mTitle;
    private String mTitle1;
    private ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bottom);
        Intent intent = getIntent();
        mId = intent.getIntExtra("id", 346);
        Log.e(TAG, "onCreate: "+mId );
        initView();
        Log.e(TAG, "onCreate:   initView() 执行完了" );
        setupView(State.DOWN);
    }


    private void initView() {
        mPullListView = (PullToRefreshListView) findViewById(R.id.list_bottom_pulllistview);
        mTitle = (TextView) findViewById(R.id.list_bottom_title);
        mBack = (ImageView) findViewById(R.id.list_bottom_back);
        mBack.setOnClickListener(this);
        mPullListView.setMode(PullToRefreshListView.Mode.PULL_FROM_START);
        mPullListView.setOnRefreshListener(this);
        //创建适配器
        mAdapter = new ListBottomAdapter(this,null);
        mPullListView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.list_bottom_back:
                finish();
                break;
        }
    }

    enum State{
        UP,DOWN
    }
    private void setupView(final State state) {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_VIEWPAGER_LIST+mId+"/posts?limit=20&offset="+offSet);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e(TAG, "onSuccess: "+result );
                Gson gson= new Gson();
                ListBottom listBottom = gson.fromJson(result, ListBottom.class);
                List<ListBottom.DataBean.PostsBean> data = listBottom.getData().getPosts();
                Log.e(TAG, "onSuccess:  Short_title "+data.get(1).getShort_title() );
                mTitle1 = listBottom.getData().getTitle();
                mTitle.setText(mTitle1);
                if (state == State.DOWN) {
                    mAdapter.upData(data);
                }else {
                    mAdapter.addRes(data);
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
                mPullListView.onRefreshComplete();
            }
        });

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        offSet = 0;
        setupView(State.DOWN);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        offSet += 20;
        setupView(State.UP);
    }
}
