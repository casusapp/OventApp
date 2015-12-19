package com.ovent.presentation;

import android.support.multidex.MultiDexApplication;

import com.ovent.data.converters.GsonConverter;
import com.ovent.data.retrofit.RetrofitFactory;
import com.ovent.data.utils.RealmFactory;

import net.danlew.android.joda.JodaTimeAndroid;

/**
 * Author : Kunal Chavhan
 * Date : 19/12/15.
 * Email : kunal.chavhan005@gmail.com
 */
public class Ovent extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        JodaTimeAndroid.init(getApplicationContext());
        RealmFactory.Init(getApplicationContext());
        GsonConverter.Init();
        RetrofitFactory.initRetrofitService();
    }
}
