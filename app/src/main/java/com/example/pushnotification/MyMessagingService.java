package com.example.pushnotification;

import android.app.Notification;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


public class MyMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyMessagingService";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);



        String value = remoteMessage.getData().get("time");
        long val = Long.parseLong(value);
        long end = SystemClock.elapsedRealtime() + val;

//        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody(), end);
        showNotification(remoteMessage.getData().get("title"),remoteMessage.getData().get("body"), end);

    }

    private void showNotification(String title, String message, long end) {

        RemoteViews collapsedView = new RemoteViews(getPackageName(), R.layout.notification_collapsed);
        RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.notification_expanded);

        collapsedView.setTextViewText(R.id.text_view_collapsed_1,title);
        collapsedView.setChronometer(R.id.my_chronometer, end, null, true);
        collapsedView.setTextViewText(R.id.text_view_collapsed_2,message);

//        expandedView.setImageViewResource(R.id.image_view_expanded,R.drawable.giphy);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "MyNotifications")
                .setSmallIcon(R.drawable.ic_launcher_background)
//                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(collapsedView)
//                .setCustomBigContentView(expandedView)
                ;

        final Notification notification = mBuilder.build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(999,notification);

    }

}
