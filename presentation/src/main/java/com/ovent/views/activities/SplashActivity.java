package com.ovent.views.activities;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;

import com.ovent.R;
import com.ovent.utils.Intents;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public final class SplashActivity extends BaseActivity {
    private static String TAG = "##SplashActivity##";

    @Bind(R.id.signup)
    Button mSignUp;
    @Bind(R.id.login)
    Button mLogin;

    @OnClick(R.id.login)
    void login(){
        startActivity(Intents.getLoginIntent());
    }

    @OnClick(R.id.signup)
    void signup(){
        startActivity(Intents.getSignUpIntent());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

    }

}
