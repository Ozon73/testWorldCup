package com.example.ibrahim.testworldcup.data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ibrahim on 30/12/17.
 */

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "save_contents";
    private static final String DRIVER_MESSAGE_NAME_KEY = "driver_message_name";


    private static final String TAG_TOKEN = "tagtoken";
    private static SharedPrefManager mInstance;
    private static Context mCtx;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    public SharedPrefManager (Context context) {
        mCtx = context;
        pref=mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);

        }
        return mInstance;
    }


    public boolean saveDeviceToken(String token){
        editor = pref.edit();
        editor.putString(TAG_TOKEN, token);
        editor.apply();
        return true;
    }
    //fetch the device token
    public String getDeviceToken(){
        pref = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return  pref.getString(TAG_TOKEN, null);
    }
}