package com.ovent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.onesignal.OneSignal;
import com.ovent.data.converters.GsonConverter;
import com.ovent.data.retrofit.RetrofitFactory;
import com.ovent.data.utils.RealmFactory;
import com.ovent.receiver.NotificationHandler;
import com.ovent.views.activities.HomeActivity;
import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Author : Kunal Chavhan
 * Date : 19/12/15.
 * Email : kunal.chavhan005@gmail.com
 */
public class Ovent extends MultiDexApplication {
    private static String TAG = "##Ovent##";
    @Override
    public void onCreate() {
        super.onCreate();

        JodaTimeAndroid.init(getApplicationContext());
        RealmFactory.Init(getApplicationContext());
        GsonConverter.Init();
        RetrofitFactory.initRetrofitService();
        OneSignal.startInit(this)
                .setNotificationOpenedHandler(new NotificationHandler(this))
                .init();
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
