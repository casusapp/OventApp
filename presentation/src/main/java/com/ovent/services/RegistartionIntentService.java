package com.ovent.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Author : Kunal Chavhan
 * Date : 3/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class RegistartionIntentService extends IntentService {

    private static final String TAG = "RegIntentService";
    private static final String[] TOPICS = {"global"};

    public RegistartionIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
