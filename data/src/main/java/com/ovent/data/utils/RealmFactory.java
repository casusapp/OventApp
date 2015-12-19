package com.ovent.data.utils;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Kunal on 18/12/15.
 */
public final class RealmFactory {
    public static void Init(final Context context){
        Realm.setDefaultConfiguration(new RealmConfiguration.Builder(context).build());
    }
}