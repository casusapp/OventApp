package com.ovent.presentation.views.activities;

import android.os.Bundle;
import android.app.Activity;

import com.ovent.presentation.R;
import com.ovent.presentation.views.fragments.BaseFragment;
import com.ovent.presentation.views.fragments.CreateEventFragment;

public final class CreateEvent extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        addFragment(R.id.activity_create_event, CreateEventFragment.newInstance(),CreateEventFragment.TAG);
    }

}
