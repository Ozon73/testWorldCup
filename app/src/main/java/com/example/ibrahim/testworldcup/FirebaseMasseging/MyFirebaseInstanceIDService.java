package com.example.ibrahim.testworldcup.FirebaseMasseging;

import android.util.Log;

import com.example.ibrahim.testworldcup.data.SharedPrefManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by ibrahim on 24/12/17.
 */


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        storeToken(refreshedToken);
    }

    private void storeToken(String token) {
     //TODO get Token of the device and save in SharedPref to send  it to server every loging in
        SharedPrefManager.getInstance(getApplicationContext()).saveDeviceToken(token);

    }
}