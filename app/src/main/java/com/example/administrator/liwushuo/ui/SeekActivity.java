package com.example.administrator.liwushuo.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.SeekAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.classifymodel.SeekList;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SeekActivity extends BaseActivity {

    @BindView(R.id.seek_editText)
    EditText seekEditText;
    @BindView(R.id.seek_btn_cancel)
    Button seekBtnCancel;
    @BindView(R.id.seek_tv)
    TextView seekTv;
    @BindView(R.id.seek_recyclerView)
    RecyclerView seekRecyclerView;
    @BindView(R.id.seek_image_back)
    ImageView seekImageBack;


    private List<String> mData;
    private SeekAdapter mSeekAdapter;
    private GridLayoutManager mGridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        ButterKnife.bind(this);
        initView();
        initData();
        setData();
        setListener();
    }

    private void setListener() {
        seekImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initView() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

    }

    private void initData() {
        mData = new ArrayList<>();
        //适配器
        mSeekAdapter = new SeekAdapter(this, mData);
        x.http().get(new RequestParams(HttpConstant.SEEKMORE), new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    SeekList seekList = new Gson().fromJson(result, SeekList.class);
                    mData.addAll(seekList.getData().getHot_words());
                    mSeekAdapter.notifyDataSetChanged();
                    mSeekAdapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Integer position = (Integer) v.getTag();

                        }
                    });
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
        mGridLayoutManager = new GridLayoutManager(this,6);
        seekRecyclerView.setLayoutManager(mGridLayoutManager);
        seekRecyclerView.setAdapter(mSeekAdapter);

    }

}
