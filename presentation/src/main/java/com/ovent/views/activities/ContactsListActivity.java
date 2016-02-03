package com.ovent.views.activities;

import android.os.Bundle;
import android.app.Activity;

import com.ovent.R;
import com.ovent.views.fragments.ContactsListFragment;


public class ContactsListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_list);
        addFragment(R.id.activity_create_event, ContactsListFragment.newInstance(), ContactsListFragment.TAG);
    }

}
