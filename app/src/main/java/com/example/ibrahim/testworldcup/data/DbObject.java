package com.example.ibrahim.testworldcup.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.ibrahim.testworldcup.data.DBHelber;

/**
 * Created by ibrahim on 26/12/17.
 */

public class DbObject {
    private static DBHelber dbHelper;
    private SQLiteDatabase db;

    public DbObject (Context context) {
        dbHelper = new DBHelber( context );
        this.db = dbHelper.getReadableDatabase();


    }

    public SQLiteDatabase getDbConnection() {
        return this.db;
    }

    public SQLiteDatabase writeDbConnection() {

        return dbHelper.getWritableDatabase();
    }
    public void closeDbConnection() {
        if (this.db != null) {
            this.db.close();
        }
    }
}
