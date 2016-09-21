package com.example.administrator.liwushuo.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.ui.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class MineFragment extends BaseFragment {
    public static final String TAG = MineFragment.class.getSimpleName();
    @BindView(R.id.iv_profile_show)
    ImageView ivProfileShow;
    @BindView(R.id.iv_profile_icon)
    ImageView ivProfileIcon;
    @BindView(R.id.tv_pro_name)
    TextView tvProName;
    @BindView(R.id.iv_profile_gouwu)
    ImageView ivProfileGouwu;
    @BindView(R.id.iv_profile_dingdan)
    ImageView ivProfileDingdan;
    @BindView(R.id.iv_profile_liquan)
    ImageView ivProfileLiquan;
    @BindView(R.id.iv_profile_guanzhu)
    ImageView ivProfileGuanzhu;
    @BindView(R.id.iv_profile_kefu)
    ImageView ivProfileKefu;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        layout = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, layout);
        return layout;

    }

    @OnClick({R.id.iv_profile_show, R.id.iv_profile_icon, R.id.tv_pro_name, R.id.iv_profile_gouwu, R.id.iv_profile_dingdan, R.id.iv_profile_liquan, R.id.iv_profile_guanzhu, R.id.iv_profile_kefu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_profile_show:
                break;
            case R.id.iv_profile_icon:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_pro_name:
                Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.iv_profile_gouwu:
                Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent2);
                break;
            case R.id.iv_profile_dingdan:
                Intent intent3 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent3);
                break;
            case R.id.iv_profile_liquan:
                Intent intent4 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent4);
                break;
            case R.id.iv_profile_guanzhu:
                Intent intent5 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent5);
                break;
            case R.id.iv_profile_kefu:
                Intent intent6 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent6);
                break;
        }
    }
}
