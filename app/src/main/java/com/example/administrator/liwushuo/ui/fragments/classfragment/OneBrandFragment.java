package com.example.administrator.liwushuo.ui.fragments.classfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.ui.fragments.BaseFragment;

/**
 * Created by liuhui on 2016/9/20.
 * 单品
 */
public class OneBrandFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       layout= inflater.inflate(R.layout.fragment_classify_onebrand,container,false);
        return layout;
    }

}
