package com.ovent.views.activities;

import android.os.Bundle;
import android.app.Activity;

import com.ovent.R;

import com.ovent.views.fragments.SignupFragment;

public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        addFragment(R.id.activity_signup, SignupFragment.newInstance(), SignupFragment.TAG);
    }

}
