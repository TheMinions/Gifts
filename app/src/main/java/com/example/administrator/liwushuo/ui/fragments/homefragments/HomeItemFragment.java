package com.example.administrator.liwushuo.ui.fragments.homefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.HomeItemAdapter;
import com.example.administrator.liwushuo.constant.HttpConstant;
import com.example.administrator.liwushuo.model.homemodel.HomeList;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class HomeItemFragment extends BaseFragment {

    private ListView mListView;
    private int id;
    private HomeItemAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.home_fragment_item_one,container,false);
        Bundle bundle = getArguments();
        int id = bundle.getInt("id");
        initView();
        setupView();
        return layout;
    }

    private void initView() {
        mListView = ((ListView) layout.findViewById(R.id.home_fragment_listview));
        mAdapter = new HomeItemAdapter(null,getActivity());
        mListView.setAdapter(mAdapter);
    }

    private void setupView() {
        RequestParams requestParams = new RequestParams(HttpConstant.HOME_FRAGMENT+id+"/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0");
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                HomeList homeList = gson.fromJson(result, HomeList.class);
                List<HomeList.DataBean.ItemsBean> data = homeList.getData().getItems();
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
