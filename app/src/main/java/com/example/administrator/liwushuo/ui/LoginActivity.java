package com.example.administrator.liwushuo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.administrator.liwushuo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.iv_login_exit)
    ImageView ivLoginExit;
    @BindView(R.id.iv_signin_qq)
    ImageView ivSigninQq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_login);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.iv_login_exit, R.id.iv_signin_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_login_exit:
                finish();
                break;
            case R.id.iv_signin_qq:
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
