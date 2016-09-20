package com.example.administrator.liwushuo.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.liwushuo.R;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class ClassifyFragment extends BaseFragment {
    public static final String TAG = ClassifyFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_classify,container,false);
        return layout;
    }
}
