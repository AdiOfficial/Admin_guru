package com.example22.lenovo.admin.notif;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class NotificationOrea extends ContextWrapper {

    private static String CHANNEL_ID = "com.udacoding.firebaseseaa";
    private static String CHANNEL_NAME = "firebaseseaa";





    private NotificationManager notificationManager ;

    public NotificationOrea(Context base) {
        super(base);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            
            createChannel();
            
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {

        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);

        channel.enableLights(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);


        getManager().createNotificationChannel(channel);

    }

    public NotificationManager getManager(){

        if(notificationManager == null){
            notificationManager = (NotificationManager) getSystemService(Context.
                    NOTIFICATION_SERVICE);


        }

        return notificationManager;
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder
    getOreoNotification(String title ,
                        String body ,
                        PendingIntent pendingIntent,
                        Uri sound ,
                        String icon
                                                    ){
        return new Notification.Builder
                (getApplicationContext(),CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setContentText(body)
                .setContentTitle(title)
                .setSmallIcon(Integer.parseInt(icon))
                .setSound(sound)
                .setAutoCancel(true);


    }
}
