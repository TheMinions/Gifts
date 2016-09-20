package com.example.administrator.liwushuo.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class BaseFragment extends Fragment {
    //BaseFragment  所有Fragment的父类  提供公共属性的初始化

    protected View layout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}