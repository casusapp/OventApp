package com.ovent.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.ovent.R;

import java.io.IOException;

/**
 * Author : Kunal Chavhan
 * Date : 3/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class RegistartionIntentService extends IntentService {
    private static final String TAG = "RegIntentService";
  //  private static final String[] TOPICS = {"global"};

    public RegistartionIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        InstanceID instanceID =InstanceID.getInstance(this);
        try {
            String token = instanceID.getToken(getString(R.string.gcm_senderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE,null);
            Log.d(TAG,"gcm token : "+token);
            sendTokenToServer(token);
        } catch (IOException e) {
            Log.d(TAG, "failed to get gcm token" );
            e.printStackTrace();
        }



    }


    private void sendTokenToServer(final String token){
    //TODO instantiate GcmPresenter and send this token to server.
    }


}
