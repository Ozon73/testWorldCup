package com.example.ibrahim.testworldcup.FirebaseMasseging;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Administrator on 07/07/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    Intent intent;
    MyNotificationManager mNotificationManager;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());
            try {
                JSONObject json = new JSONObject (remoteMessage.getData().toString());
                getPushUserNotification(json);
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }

    }
    //method for recieve the Notifications with jsson information will pass
    private void getPushUserNotification(JSONObject json) {
        Log.v(TAG, "Notification JSON " + json.toString());
        try {

            //all unique json data  with all type of Notification
            JSONObject data = json.getJSONObject("data");
            String type = data.getString("type");
            String title = data.getString("title");

           // mNotificationManager = new MyNotificationManager(getApplicationContext());
            Log.v(TAG, "Notification type : " + type);

       /*    //statement if the Notification com from user by passing the sort of type value
            if(type.contains (USER_MESSAGE)){
                String from = data.getString ("from");
                String to = data.getString ("to");
                intent = new Intent (getApplicationContext(), MainActivityDrivers.class);
                mNotificationManager.showUserNotification (title, from, to, intent);
            }
            //statement if the Notification com from driver by passing the sort of type value
            else if
                    (type.contains (DRIVER_MESSAGE)){
                 intent = new Intent (getApplicationContext(), MainActivityUsers.class);
                mNotificationManager.showDriverNotification (title, intent);

            }
            //statement if the Notification com from driver by passing the sort of type value
            else if(type.contains (DRIVER_APPLY_ORDER_MESSAGE)) {
                intent = new Intent (getApplicationContext (), MainActivityUsers.class);
                mNotificationManager.showDriverNotification (title, intent);

            }
            else if(type.contains (USER_CANCEL_ORDER_MESSAGE)) {
                intent = new Intent (getApplicationContext (), MainActivityUsers.class);
                mNotificationManager.showDriverNotification (title, intent);

            }

            else if(type.contains (DRIVER_CANCEL_ORDER_MESSAGE)) {
                intent = new Intent (getApplicationContext (), MainActivityUsers.class);
                mNotificationManager.showDriverNotification (title, intent);

            }*/

        } catch (JSONException e) {
            Log.e(TAG, "Json Exception: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
    }


}