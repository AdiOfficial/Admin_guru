package com.example22.lenovo.admin;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example22.lenovo.admin.chat_package.DetailChat;
import com.example22.lenovo.admin.notif.NotificationOrea;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyServiceMessaging extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("result notif",remoteMessage.getData().toString());



        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            sendNotifOreo(remoteMessage);
        }
        else{
        sendNotif(remoteMessage);
         }






    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void sendNotifOreo(RemoteMessage remoteMessage) {
        String user = remoteMessage.getData().get("user");
        String title = remoteMessage.getData().get("title");
        String body = remoteMessage.getData().get("body");
        String icon = remoteMessage.getData().get("icon");
        String key = remoteMessage.getData().get("key");


        //create notif




        Intent intent = new Intent(this, DetailChat.class);
        Bundle bundle = new Bundle();
        bundle.putString("receiver",user);
        bundle.putString("key",key);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);


        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationOrea notificationOrea = new NotificationOrea(this);

        Notification.Builder builder  = notificationOrea.getOreoNotification(title,body,pendingintent,sound,icon);

        notificationOrea.getManager().notify(0,builder.build());

    }

    private void sendNotif(RemoteMessage remoteMessage) {

        String user = remoteMessage.getData().get("user");
        String title = remoteMessage.getData().get("title");
        String body = remoteMessage.getData().get("body");
        String icon = remoteMessage.getData().get("icon");
        String key = remoteMessage.getData().get("key");


        //create notif




        Intent intent = new Intent(this,DetailChat.class);
        Bundle bundle = new Bundle();
        bundle.putString("username",user);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        PendingIntent pendingintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);


//         int j = Integer.parseInt(user.replaceAll("[\\D]",""));
        Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notif = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(Integer.parseInt(icon))
                .setSound(sound)
                .setAutoCancel(true)
                .setContentIntent(pendingintent);

        int i = 0 ;




        NotificationManager notif12 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notif12.notify(i,notif.build());



    }
}
