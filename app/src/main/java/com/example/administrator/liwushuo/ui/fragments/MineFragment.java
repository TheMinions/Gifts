package com.example.administrator.liwushuo.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.liwushuo.R;
import com.example.administrator.liwushuo.ui.LoginActivity;
import com.example.administrator.liwushuo.ui.SettingActivity;
import com.rock.qrcodelibrary.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/18 0018.
 */
public class MineFragment extends BaseFragment {
    public static final String TAG = MineFragment.class.getSimpleName();
    private static final int QR_REQUEST_CODE = 100;
    private static final int RESULT_OK = -1;
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
    @BindView(R.id.settings)
    ImageView settings;
    @BindView(R.id.mine_rb1)
    RadioButton mineRb1;
    @BindView(R.id.mine_rb2)
    RadioButton mineRb2;
    @BindView(R.id.mine_rg1)
    RadioGroup mineRg1;
    @BindView(R.id.mine_view_rb1)
    View mineViewRb1;
    @BindView(R.id.mine_view_rb2)
    View mineViewRb2;
    @BindView(R.id.mine_login_linear)
    LinearLayout mineLoginLinear;
    @BindView(R.id.mine_msg_login)
    ImageView mineMsgLogin;
    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        layout = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, layout);
        return layout;

    }

    @OnClick({R.id.iv_profile_show,R.id.mine_msg_login, R.id.mine_login_linear, R.id.mine_rb1, R.id.mine_rb2, R.id.iv_profile_icon, R.id.settings, R.id.tv_pro_name, R.id.iv_profile_gouwu, R.id.iv_profile_dingdan, R.id.iv_profile_liquan, R.id.iv_profile_guanzhu, R.id.iv_profile_kefu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_msg_login:
                Intent intent10 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent10);
                break;
            case R.id.mine_login_linear:
                Intent intent9 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent9);
                break;
            case R.id.iv_profile_show:
                // 启动扫描页面
                Intent intent7 = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent7, QR_REQUEST_CODE);
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
            case R.id.settings:
                Intent intent8 = new Intent(getActivity(), SettingActivity.class);
                startActivity(intent8);
                break;
            case R.id.mine_rb1:
                mineViewRb1.setVisibility(View.VISIBLE);
                mineViewRb2.setVisibility(View.INVISIBLE);
                break;
            case R.id.mine_rb2:
                mineViewRb1.setVisibility(View.INVISIBLE);
                mineViewRb2.setVisibility(View.VISIBLE);
                break;
            case R.id.mine_rg1:
                break;
        }
    }

    //      扫描结果
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == QR_REQUEST_CODE) {
            Toast.makeText(getActivity(), "扫描成功", Toast.LENGTH_SHORT).show();
        }
    }
}
