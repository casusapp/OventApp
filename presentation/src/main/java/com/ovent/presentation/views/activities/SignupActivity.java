package com.ovent.presentation.views.activities;

import android.os.Bundle;
import android.app.Activity;

import com.ovent.presentation.R;

import com.ovent.presentation.views.fragments.SignupFragment;

public class SignupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        addFragment(R.id.activity_signup, SignupFragment.newInstance(), SignupFragment.TAG);
    }

}
