package com.ovent.views.activities;

import android.app.Activity;
import android.os.Bundle;

import com.ovent.R;
import com.ovent.views.activities.BaseActivity;
import com.ovent.views.fragments.AccountFragment;

public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        addFragment(R.id.activity_account, AccountFragment.newInstance(),AccountFragment.TAG);
    }
}
