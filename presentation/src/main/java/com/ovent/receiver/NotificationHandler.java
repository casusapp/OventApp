package com.ovent.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ovent.views.activities.Notification;
import java.util.HashMap;

/**
 * Author : Kunal Chavhan
 * Date : 25/2/16.
 * Email : kunal.chavhan005@gmail.com
 */
public class NotificationHandler extends BroadcastReceiver {
    private static final String TAG = "customHandler";
    @Override
    public void onReceive(Context context, Intent intent)
    {

    }

//TODO if need to handle notifications this method can be useful
/*
    private void generateNotification(Context context, String message,
                                      long when, String query) {

        int icon = R.drawable.icon;
        long when = System.currentTimeMillis();
        String appname = context.getResources().getString(R.string.app_name);
        NotificationManager notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        int currentapiVersion = android.os.Build.VERSION.SDK_INT;
        Notification notification;

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                intent, 0);

        if (currentapiVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
            notification = new Notification(icon, message, when);
            notification.setLatestEventInfo(context, appname, message,
                    contentIntent);
            notification.flags = Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify((int) when, notification);

        } else {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    context);
            notification = builder.setContentIntent(contentIntent)
                    .setSmallIcon(icon).setTicker(appname).setWhen(when)
                    .setAutoCancel(true).setContentTitle(appname)
                    .setContentText(message).build();

            notificationManager.notify((int) when, notification);

        }

    }*/
}
