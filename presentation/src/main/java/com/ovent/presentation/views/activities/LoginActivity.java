package com.ovent.presentation.views.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.ovent.presentation.R;
import com.ovent.presentation.views.fragments.LoginFragment;

public final class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        addFragment(R.id.activity_login, LoginFragment.newInstance(), LoginFragment.TAG);
    }

}
