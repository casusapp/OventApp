package com.ovent;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.appboy.Appboy;
import com.ovent.data.converters.GsonConverter;
import com.ovent.data.retrofit.RetrofitFactory;
import com.ovent.data.utils.RealmFactory;
import com.ovent.views.activities.HomeActivity;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.SaveCallback;


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

        Appboy.configure(getApplicationContext(),getString(R.string.com_appboy_api_key));

    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
