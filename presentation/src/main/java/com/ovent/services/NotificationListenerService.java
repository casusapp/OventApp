package com.ovent.services;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

/**
 * Author : Kunal Chavhan
 * Date : 4/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public final class NotificationListenerService extends GcmListenerService{
    private static final String TAG = "##NotificationListenerService##";

    /**
     * called when the message is received
     * @param from SenderID od the sender
     * @param data Data bundle containing message data as key/value pairs
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        //super.onMessageReceived(from, data);
        String message = data.getString("message");

    }
}
