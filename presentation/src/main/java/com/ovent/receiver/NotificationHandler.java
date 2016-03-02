package com.ovent.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.onesignal.OneSignal;
import com.ovent.views.activities.Notification;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Author : Kunal Chavhan
 * Date : 25/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class NotificationHandler implements OneSignal.NotificationOpenedHandler {
    private static final String TAG = "##NotificationHandler##";
    private Context mContext;

    public NotificationHandler(Context context) {
        mContext = context;
    }

    @Override
    public void notificationOpened(String message, JSONObject additionalData, boolean isActive) {
        try {
            if (additionalData != null) {
                if (additionalData.has("actionSelected"))
                    Log.d("OneSignalExample", "OneSignal notification button with id " + additionalData.getString("actionSelected") + " pressed");

                Log.d("OneSignalExample", "Full additionalData:\n" + additionalData.toString());
                Intent intent = new Intent(mContext, Notification.class);
                intent.putExtra("message", message);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
