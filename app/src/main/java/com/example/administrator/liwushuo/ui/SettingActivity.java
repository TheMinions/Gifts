package com.example.administrator.liwushuo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.liwushuo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.mine_pop_login_back)
    ImageView minePopLoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.mine_pop_login_back)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_pop_login_back:
                finish();
                break;
        }

    }
}
