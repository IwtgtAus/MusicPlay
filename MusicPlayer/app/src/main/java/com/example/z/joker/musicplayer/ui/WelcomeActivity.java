package com.example.z.joker.musicplayer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.z.joker.musicplayer.MainActivity;
import com.example.z.joker.musicplayer.R;

/**
 * Created by 张腾_925 on 17.6.28.
 */

public class WelcomeActivity extends BaseActivity implements View.OnClickListener {
    private TextView textView;
    private CountDownTimer mCountDownTimer = new CountDownTimer(4000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            textView.setText(millisUntilFinished / 1000 + "秒-跳过");
        }

        @Override
        public void onFinish() {
//           倒计时结束的时候跳转到程序主界面
            welcomeToMain();
        }
    };

    private void welcomeToMain() {
        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//          结束掉当前的WelcomeActivity
        finish();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        //开启倒计时
        mCountDownTimer.start();
        textView = (TextView) findViewById(R.id.textView_welcome);
        textView.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // 当前Activity摧毁时候调用
        mCountDownTimer.cancel();//倒计时取消
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        welcomeToMain();
    }
}
