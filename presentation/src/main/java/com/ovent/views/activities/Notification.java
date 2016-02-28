package com.ovent.views.activities;

import android.app.Activity;
import android.os.Bundle;

import com.ovent.R;

public class Notification extends Activity {
    public static boolean mActive=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mActive= true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        mActive= false;
    }

    public static boolean isActive(){
        return mActive;
    }
}
