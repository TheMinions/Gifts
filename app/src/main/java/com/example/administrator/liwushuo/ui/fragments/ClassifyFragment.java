package com.example.administrator.liwushuo.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.adapters.ClassifyAdapter;
import com.example.administrator.liwushuo.ui.SeekActivity;
import com.example.administrator.liwushuo.ui.fragments.classfragments.OneBrandFragment;
import com.example.administrator.liwushuo.ui.fragments.classfragments.StrtegyFragment;
import com.example.administrator.liwushuo.view.CubeTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class ClassifyFragment extends BaseFragment {
    public static final String TAG = ClassifyFragment.class.getSimpleName();
    @BindView(R.id.classify_fragment_tablayout)
    TabLayout classifyFragmentTablayout;
    @BindView(R.id.classify_fragment_bt_select)
    Button classifyFragmentBtSelect;
    @BindView(R.id.classify_fragment_viewPager)
    ViewPager classifyFragmentViewPager;

    private List<String> title;
    private List<Fragment> mFragment;
    private ClassifyAdapter mClassifyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_classify, container, false);
        ButterKnife.bind(this, layout);
        initData();
        setData();
        setListener();
        return layout;

    }
//设置监听
    private void setListener() {
        classifyFragmentBtSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SeekActivity.class);
                startActivity(intent);
                //设置动画效果
                getActivity().overridePendingTransition(R.anim.anim_activity_start,R.anim.anim_activity_close);
            }
        });
    }
//设置数据
    private void setData() {
        //ViewPager设置适配器
        classifyFragmentViewPager.setAdapter(mClassifyAdapter);
        //TabLayout 设置
        classifyFragmentTablayout.setupWithViewPager(classifyFragmentViewPager);
     // 用于设置ViewPager切换时的动画效果 true 倒叙 false 顺序
          classifyFragmentViewPager.setPageTransformer(true,new CubeTransformer());

    }
//添加数据
    private void initData() {
        title = new ArrayList<>();
        mFragment = new ArrayList<>();
        title.add("攻略");
        title.add("单品");
        for (int i = 0; i < title.size(); i++) {
            if (i==0) {
                mFragment.add(new StrtegyFragment());
            }else if (i==1) {
                mFragment.add(new OneBrandFragment());
            }
        }
        //viewPager适配器
        mClassifyAdapter = new ClassifyAdapter(getChildFragmentManager(),mFragment,title);

    }

}
