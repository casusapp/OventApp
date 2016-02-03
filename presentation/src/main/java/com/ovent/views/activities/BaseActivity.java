package com.ovent.views.activities;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.ovent.R;

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // hideActionbar();
    }

    protected void changeStatusBarColor(final int color) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            final Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(color);
        }
    }

    protected void changeActionBarColor(final int color){
        if(getSupportActionBar() == null)
            return;

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
    }

    protected void hideActionbarLogo(){
        if(getSupportActionBar() == null)
            return;

        getSupportActionBar().setIcon(
                new ColorDrawable(getResources().getColor(android.R.color.transparent)));
    }

    protected void hideActionbarText(){
        if(getSupportActionBar() == null)
            return;

        getSupportActionBar().setTitle("");
    }

    protected void hideActionbar(){
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
    }

    protected boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected void addFragment(int id, Fragment fragment, String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(id, fragment, tag).commit();
    }

    protected void removeFragment(String tag){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .remove(fragment).commit();
        }
    }

    protected void displayHomeAsUpEnabled(boolean homeAsEnabled){
        if(getSupportActionBar() == null)
            return;
        getSupportActionBar().show();
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsEnabled);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
    }
}
