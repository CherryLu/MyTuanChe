package com.bwf.tuanche.test;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.RemoteViews;

import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;

/**
 * Created by BWF on 2016/9/1.
 */
public class NotificationUtil {
    private static NotificationUtil notificationUtil;
    private NotificationManager notificationManager;
    private Notification notification;

    private NotificationUtil() {
    }

    public static NotificationUtil getInstance(){
        if (notificationUtil==null){
            notificationUtil = new NotificationUtil();
        }
        return notificationUtil;
    }

    public void showNotification(Context context, int layoutId, int notificationId){
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContent(new RemoteViews(context.getPackageName(),layoutId));
        builder.setContentIntent(getDefalutIntent(context));
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("通知来了");
        builder.setWhen(System.currentTimeMillis());
        builder .setPriority(Notification.PRIORITY_DEFAULT);
        builder .setAutoCancel(true);
        notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL | Notification.FLAG_ONLY_ALERT_ONCE;
        notificationManager.notify(notificationId,notification);

    }

    public PendingIntent getDefalutIntent(Context context) {
        Intent noticeIntent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, noticeIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }


    public void updateProgress(int progress, int notificationId){


    }
}
