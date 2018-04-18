package com.example.ibrahim.testworldcup.FirebaseMasseging;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Action;


/**
 * Created by ibrahim on 24/12/17.
 */

public class MyNotificationManager {
    public static final int ID_BIG_NOTIFICATION = 234;
    public static final int ID_SMALL_NOTIFICATION = 235;
    private static final int ACTION_APLLY_PENDING_INTENT_ID = 1;
    private static final int ACTION_IGNORE_PENDING_INTENT_ID = 14;
    private Context mCtx;

  /*  public MyNotificationManager(Context mCtx) {
        this.mCtx = mCtx;
    }
//TODO USER  NotificationFromUser that will send to driver
    public void showUserNotification (String title, String from, String to, Intent intent) {
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mCtx,
                        ID_SMALL_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);
        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.ic_launcher).setTicker(title).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.mipmap.ic_launcher))
                .setContentText ("من :\n" + to + "\n الى :" + from)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .addAction(ignorAction(mCtx))
                .addAction(applyAction(mCtx))
                .setAutoCancel(true)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_SMALL_NOTIFICATION, notification);



    }
// TODO this will control the Notification  to show in future or not show again
    private static Action applyAction(Context context) {
        Intent ignoreReminderIntent = new Intent (context, MashaweerSyncIntentService.class);
        ignoreReminderIntent.setAction(sendRespondUser.ACTION_APLLY_ORDER);
        PendingIntent ignoreReminderPendingIntent = PendingIntent.getService(
                context,
                ACTION_APLLY_PENDING_INTENT_ID,
                ignoreReminderIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Action ignoreReminderAction = new Action (R.drawable.ic_done_24dp,
                "نعم اقبل",
                ignoreReminderPendingIntent);
        return ignoreReminderAction;
    }

    private static Action ignorAction(Context context) {
        Intent incrementWaterCountIntent = new Intent (context, MashaweerSyncIntentService.class);
        incrementWaterCountIntent.setAction(sendRespondUser.ACTION_DISMISS_ORDER);
        PendingIntent incrementWaterPendingIntent = PendingIntent.getService(
                context,
                ACTION_IGNORE_PENDING_INTENT_ID,
                incrementWaterCountIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        Action drinkWaterAction = new Action (R.drawable.ic_cancel_24px,
                "لا ارغب",
                incrementWaterPendingIntent);
        return drinkWaterAction;
    }
    //TODO DRIVER NotificationFromDriver that will send back to replay on user

    public void showDriverNotification (String title, Intent intent) {
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        mCtx,
                        ID_SMALL_NOTIFICATION,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mCtx);
        Notification notification;
        notification = mBuilder.setSmallIcon(R.mipmap.ic_launcher).setTicker(title).setWhen(0)
                .setAutoCancel(true)
                .setContentIntent(resultPendingIntent)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(mCtx.getResources(), R.mipmap.ic_launcher))
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .addAction(ignorAction(mCtx))
                .addAction(applyAction(mCtx))
                .setAutoCancel(true)
                .build();

        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) mCtx.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(ID_SMALL_NOTIFICATION, notification);

*/


}
