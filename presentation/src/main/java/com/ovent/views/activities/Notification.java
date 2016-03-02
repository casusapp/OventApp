package com.ovent.views.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ovent.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Notification extends Activity {
    private static String TAG = "##Notification##";
    @Bind(R.id.notification)
    TextView mNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        if(getIntent().getStringExtra("message")!=null)
            mNotification.setText(getIntent().getStringExtra("message"));
    }
}
