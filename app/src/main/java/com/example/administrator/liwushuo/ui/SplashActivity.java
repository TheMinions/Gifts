package com.example.administrator.liwushuo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.liwushuo.R;

public class SplashActivity extends AppCompatActivity implements Handler.Callback{
    private Handler mHandler= new Handler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        mHandler.sendEmptyMessageDelayed(100,2000);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 100:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
        }
        return false;
    }

}

