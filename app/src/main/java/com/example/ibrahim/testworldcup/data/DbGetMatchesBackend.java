package com.example.ibrahim.testworldcup.data;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;

import static com.example.ibrahim.testworldcup.data.Contract.TB_MATCHES;

/**
 * Created by ibrahim on 26/12/17.
 */

public class DbGetMatchesBackend extends DbObject {

    private static final String TAG = DbGetMatchesBackend.class.getSimpleName();
    Context con;


    String language;

    public DbGetMatchesBackend (Context context) {
        super( context );
        this.con = context;
    }
     /* public ArrayList<String> getTeamA() {
        View view = new TextView (con);
        TextView tv = (TextView) view;

      Cursor cr=this.getDbConnection().query(TB_MATCHES, new String[] {TEAM_A,TEAM_B,},
                null, null, null, null, null);
        ArrayList<String> temparrayList = new ArrayList<String>();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if (cr.moveToFirst())
        {
            do
            {
                temparrayList.add(cr.getString(cr.getColumnIndex(TEAM_A)));
                temparrayList.add(cr.getString(cr.getColumnIndex(TEAM_B)));
              *//*  temparrayList.add(cr.getString(cr.getColumnIndex(DATE)));
                temparrayList.add(cr.getString(cr.getColumnIndex(IMAGE_FOR_TEAM_A)));
                temparrayList.add(cr.getString(cr.getColumnIndex(IMAGE_FOR_TEAM_B)));
                temparrayList.add(cr.getString(cr.getColumnIndex(AWAY_RESULT)));
                temparrayList.add(cr.getString(cr.getColumnIndex(STADIUM)));
                temparrayList.add(cr.getString(cr.getColumnIndex(FINISHED)));
*//*
            }
            while (cr.moveToNext());
        }
        return temparrayList;


    }*/
/*


    public ArrayList<String> getTeamB() {
        View view = new TextView (con);
        TextView tv = (TextView) view;

        Cursor cr=this.getDbConnection().query(TB_MATCHES, new String[] {B_ID}, null, null, null, null, null);
        ArrayList<String> temparrayList = new ArrayList<String>();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if (cr.moveToFirst())
        {
            do
            {
                temparrayList.add(cr.getString(cr.getColumnIndex(B_ID)));
            }
            while (cr.moveToNext());
        }
        return temparrayList;


    }
    public void addMtches(String id, String teamA,String teamB,String finished,String history ) {

        SQLiteDatabase db = this.writeDbConnection();
        ContentValues values = new ContentValues();

        values.put( ID, id );
        values.put( A_ID, teamA );
        values.put( B_ID, teamB );
        values.put( FINISHED, finished );
        values.put( HISTORY, history );

        long query = db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add TB_MATCHES list inserted into sqlite: " + query );

        db.close();
    }

    public void addTeams(String id, String teamName,String groub,String palyed,String win
                                                          ,String draw, String lose,String score,String goals,String active) {

        SQLiteDatabase db = this.writeDbConnection();
        ContentValues values = new ContentValues();

        values.put( ID, id );
        values.put( TEAM_NAME, teamName );
        values.put( GROUPS, groub );
        values.put( PLAYED, palyed );
        values.put( WIN, win );
        values.put( DRAW, draw );
        values.put( LOSE, lose );
        values.put( SCORE, score );
        values.put( GOALS, goals );
        values.put( ACTIVE, active );



        long query = db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add TB_TEAMES list inserted into sqlite: " + query );

        db.close();
    }
*/


}