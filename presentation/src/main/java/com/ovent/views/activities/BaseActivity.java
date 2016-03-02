package com.ovent.views.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.github.pwittchen.reactivenetwork.library.ConnectivityStatus;
import com.github.pwittchen.reactivenetwork.library.ReactiveNetwork;
import com.ovent.R;
import com.ovent.views.custom.OventAlertDialog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    protected String mLastTag;
    private Subscription mNetworkChecker;
    private OventAlertDialog mInternetConnectivityDialog;
    private ProgressDialog mConnectivityLoader;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor();

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


    /**
     * Method checks for internet connection.
     */
    private void checkNetworkConnectivity() {
        // Connection status check
        if (mNetworkChecker != null && !mNetworkChecker.isUnsubscribed())
            mNetworkChecker.unsubscribe();
        mNetworkChecker = null;
        mNetworkChecker = new ReactiveNetwork().enableInternetCheck().observeConnectivity(this)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ConnectivityStatus>() {
                    @Override
                    public void call(final ConnectivityStatus connectivityStatus) {
                        switch (connectivityStatus) {
                            case UNKNOWN:
                            case OFFLINE:
                                handleNoInternetConnectivity();
                                break;
                        }
                    }
                });
    }

    protected void handleNoInternetConnectivity() {
        if (mInternetConnectivityDialog != null)
            return;
        OventAlertDialog.Builder builder = new OventAlertDialog.Builder(this);
        builder.setHeaderImageResource(R.drawable.common_full_open_on_phone);
        builder.setDialogTitle(R.string.connectivity_error_title);
        builder.setDialogContent(R.string.connectivity_error_message);
        builder.setPositiveButton(R.string.try_again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(final DialogInterface dialog, int which) {
                showConnectivityLoader();
                mExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        ConnectivityStatus newConnectivityStatus = new ReactiveNetwork()
                                .enableInternetCheck()
                                .observeConnectivity(BaseActivity.this)
                                .toBlocking()
                                .first();
                        switch (newConnectivityStatus) {
                            case UNKNOWN:
                            case OFFLINE:
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        dismissConnectivityLoader();
                                        handleNoInternetConnectivity();
                                    }
                                });
                                break;
                            case WIFI_CONNECTED_HAS_INTERNET:
                            case MOBILE_CONNECTED:
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        dismissConnectivityLoader();
                                        dialog.dismiss();
                                    }
                                });
                                break;
                            default:
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        dismissConnectivityLoader();
                                        handleNoInternetConnectivity();
                                    }
                                });
                                break;
                        }
                    }
                });

            }
        });
        mInternetConnectivityDialog = builder.build();
        mInternetConnectivityDialog.show();
    }

    /**
     * To show connectivity loader
     */
    private synchronized void showConnectivityLoader() {
        if (mConnectivityLoader != null && mConnectivityLoader.isShowing())
            return;
        mConnectivityLoader = new ProgressDialog(this);
        mConnectivityLoader.setMessage("Checking for connectivity...");
        mConnectivityLoader.setCancelable(false);
        mConnectivityLoader.setIndeterminate(true);
        mConnectivityLoader.show();
    }

    /**
     * To hide connectivity loader
     */
    private synchronized void dismissConnectivityLoader() {
        if (mConnectivityLoader == null)
            return;
        mConnectivityLoader.dismiss();
        mConnectivityLoader = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkNetworkConnectivity();

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mInternetConnectivityDialog != null && mInternetConnectivityDialog.isShowing()) {
            mInternetConnectivityDialog.hide();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContext = null;
        if (mNetworkChecker != null && !mNetworkChecker.isUnsubscribed())
            mNetworkChecker.unsubscribe();
    }
}
