package com.ovent.presentation.views.activities;

import android.app.Activity;
import android.os.Bundle;

import com.ovent.presentation.R;
import com.ovent.presentation.views.fragments.AccountFragment;

public class AccountActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        addFragment(R.id.activity_account, AccountFragment.newInstance(),AccountFragment.TAG);
    }
}
