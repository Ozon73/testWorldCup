package com.example.ibrahim.testworldcup.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import static com.example.ibrahim.testworldcup.data.Contract.AWAY_RESULT;
import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.CITY;
import static com.example.ibrahim.testworldcup.data.Contract.DATABASE_NAME;
import static com.example.ibrahim.testworldcup.data.Contract.DATE;
import static com.example.ibrahim.testworldcup.data.Contract.DATE_FORMATING;
import static com.example.ibrahim.testworldcup.data.Contract.DAY;
import static com.example.ibrahim.testworldcup.data.Contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_A;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_B;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_C;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_D;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_E;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_F;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_G;
import static com.example.ibrahim.testworldcup.data.Contract.GROUP_H;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_RESULT;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.ICON;
import static com.example.ibrahim.testworldcup.data.Contract.ID;

import static com.example.ibrahim.testworldcup.data.Contract.ISO2;
import static com.example.ibrahim.testworldcup.data.Contract.LAT;
import static com.example.ibrahim.testworldcup.data.Contract.LNG;
import static com.example.ibrahim.testworldcup.data.Contract.NAME;
import static com.example.ibrahim.testworldcup.data.Contract.RSULT;
import static com.example.ibrahim.testworldcup.data.Contract.STADIUM;
import static com.example.ibrahim.testworldcup.data.Contract.TB_GROUPS;
import static com.example.ibrahim.testworldcup.data.Contract.TB_MATCHES;
import static com.example.ibrahim.testworldcup.data.Contract.TB_STADIUMS;
import static com.example.ibrahim.testworldcup.data.Contract.TB_TEAMES;
import static com.example.ibrahim.testworldcup.data.Contract.TB_TV_CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.TODAY;
import static com.example.ibrahim.testworldcup.data.Contract.TYPE;


public class DBHelber extends SQLiteOpenHelper {

    private static final int SCHEMA = 3;
    private static final String TAG = DBHelber.class.getSimpleName ();


    final String CREATE_TB_STADIUMS =
            "CREATE TABLE " + TB_STADIUMS + "(" +
                    ID + " INTEGER PRIMARY KEY , " +
                    CITY + " VARCHAR(100) NOT NULL, " +
                    NAME + " VARCHAR(100) NOT NULL, " +
                    LAT + " VARCHAR(100) NOT NULL, " +
                    LNG + " VARCHAR(100) NOT NULL " +")";


    final String CREATE_TV_CHANNELS =
            "CREATE TABLE " + TB_TV_CHANNELS + "(" +
                    ID + " INTEGER PRIMARY KEY , " +
                    NAME + " VARCHAR(100) NOT NULL, " +
                    ICON + " VARCHAR(100) NOT NULL " +")";




    final String CREATE_TB_TEAMS =
            "CREATE TABLE " + TB_TEAMES + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    RSULT+ " INTEGER null , " +
                    NAME + " VARCHAR(100) NOT NULL  ,  " +
                    FLAG + " VARCHAR(400) NOT NULL  ,  " +
                    ISO2 + " VARCHAR(10) NOT NULL  " +")";

    final String CREATE_GROUPS=
            "CREATE TABLE " + TB_GROUPS + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    GROUP_A + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_B + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_C + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_D + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_E + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_F + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_G + " VARCHAR(10) NOT NULL  ,  " +
                    GROUP_H+ " VARCHAR(10) NOT NULL  " +")";

    final String CREATE_TB_MATCHES =
            "CREATE TABLE " + TB_MATCHES + "(" +
                    ID + " INTEGER  unique  , " +
                    NAME + " INTEGER   , " +
                    TYPE + " VARCHAR(10) NOT NULL  ," +
                    HOME_RESULT+" INTEGER , "+
                    AWAY_RESULT+" INTEGER , "+
                    DATE+" DATE , "+
                    DAY+" DATE , "+
                    FINISHED + " VARCHAR(10) NOT NULL  ," +
                    HOME_TEAM+" INTEGER, "+
                    AWAY_TEAM+" INTEGER, "+
                    HOME_TEAM_FLAG+" INTEGER, "+
                    AWAY_TEAM_FLAG+" INTEGER, "+
                    STADIUM+" INTEGER, "+
                    CHANNELS+" INTEGER, "+
                    TODAY+" DATE , "+
                    "FOREIGN KEY("+HOME_TEAM+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                    "FOREIGN KEY("+AWAY_TEAM+") REFERENCES "+TB_TEAMES+" ("+ID+") ,"+
                    "FOREIGN KEY("+HOME_TEAM_FLAG+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                    "FOREIGN KEY("+AWAY_TEAM_FLAG+") REFERENCES "+TB_TEAMES+" ("+ID+"), "+
                    "FOREIGN KEY("+STADIUM+") REFERENCES "+TB_STADIUMS+" ("+ID+"), "+
                    "FOREIGN KEY("+CHANNELS+") REFERENCES "+TB_TV_CHANNELS+" ("+ID+")"+")";




    public DBHelber (Context context) {
        super (context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate (SQLiteDatabase sqLiteDatabase) {
        //TODO creating table of users

        sqLiteDatabase.execSQL (CREATE_TB_STADIUMS);
        sqLiteDatabase.execSQL (CREATE_TV_CHANNELS);
        sqLiteDatabase.execSQL (CREATE_TB_TEAMS);
        sqLiteDatabase.execSQL (CREATE_GROUPS);
       sqLiteDatabase.execSQL (CREATE_TB_MATCHES);


    }

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if (i < 2) {
            sqLiteDatabase.execSQL (CREATE_TB_STADIUMS);
            sqLiteDatabase.execSQL (CREATE_TV_CHANNELS);
            sqLiteDatabase.execSQL (CREATE_TB_TEAMS);
            sqLiteDatabase.execSQL (CREATE_GROUPS);
            sqLiteDatabase.execSQL (CREATE_TB_MATCHES);
        }
        if (i < 3) {
      //     sqLiteDatabase.execSQL (CREATE_TB_MATCHES);
        }

    }
    //add to all contentnts of stadiums in sqlite
    public void addStadiumsList(long id, String city, double lat, double lng, String name) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( CITY, city );
        values.put( NAME, name );
        values.put( LAT, lat );
        values.put( LNG, lng );
        long query = db.insertWithOnConflict( TB_STADIUMS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_STADIUMS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_MATCHES list inserted into sqlite: " + query );

        db.close();
    }
    //add to all contentnts of channels in sqlite
    public void addChannelsList(long id, String name, String icon) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( NAME, name );
        values.put( ICON, icon );
        long query = db.insertWithOnConflict( TB_TV_CHANNELS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_TV_CHANNELS, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_TV_CHANNELS list inserted into sqlite: " + query );
        db.close();
    }

    //add to all contentnts of channels in sqlite
    public void addTeamsList(long id, String name,String flag,String iso2) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( ID, id );
        values.put( NAME, name );
        values.put( FLAG, flag );
        values.put( ISO2, iso2 );
        long query = db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_TEAMES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        Log.d( TAG, "add TB_TEAMES  list inserted into sqlite: " + query );
        db.close();
    }
    public void addMathesList(long id, long name, String type, long home_team,
                              long away_team, long home_result,long away_result,String date,String day, long stadium,long channels, boolean finished) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMATING);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        String formattedNow = simpleDateFormat.format(new  Date(System.currentTimeMillis()));



        values.put( ID, id );
        values.put( NAME, name );

        values.put( TYPE, type );
        values.put( HOME_TEAM, home_team );
        values.put( AWAY_TEAM, away_team );
        values.put( HOME_RESULT, home_result );
        values.put( AWAY_RESULT, away_result );
        values.put( DATE, date );
        values.put( DAY, day );
        values.put( STADIUM, stadium );
        values.put( CHANNELS, channels );
        values.put( FINISHED, finished );
        values.put(TODAY, formattedNow);



        long query = db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );
        db.insertWithOnConflict( TB_MATCHES, null, values, SQLiteDatabase.CONFLICT_REPLACE );

        Log.d( TAG, "add TB_MATCHES list inserted into sqlite: " + query );


        db.close();
    }
    public String getTimeZoneByLocale(final String languageTag){
         Locale locale = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            locale = Locale.forLanguageTag(languageTag);
        }
        final Calendar cal = Calendar.getInstance(locale);
        final TimeZone timeZone = cal.getTimeZone();
        return timeZone.getID();
    }
    public Cursor getMatchesListbyvalue() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "+TB_MATCHES+"";
        String sqlf = "SELECT m1.name as 'home_team', m2.name as 'away_team',\n" +
                "       f1.flag as 'home_team_fag' , f2.flag as 'away_team_flag',\n" +
                "       s1.city as 'city',s2.lat as 'lat' ,s3.lng  as 'lng',\n" +
                "\t    tv.name as 'channels'\n" +
                "FROM tb_matches as k\n" +
                "INNER JOIN tb_teames AS m1 ON m1.id=k.home_team \n" +
                "  and k.home_team  = 1\n" +
                "INNER JOIN tb_teames AS m2 ON m2.id=k.away_team\n" +
                "  and k.away_team  = 2\n" +
                "  \n" +
                "  INNER JOIN tb_teames AS f1 ON f1.id=k.home_team \n" +
                "  and k.home_team  = 1\n" +
                "INNER JOIN tb_teames AS f2 ON f2.id=k.away_team\n" +
                "  and k.away_team  = 2\n" +
                "  \n" +
                "  INNER JOIN tb_stadiums AS s1 ON s1.id=k.stadium\n" +
                "  INNER JOIN tb_stadiums AS s2 ON s2.id=k.stadium\n" +
                "  INNER JOIN tb_stadiums AS s3 ON s3.id=k.stadium\n" +
                "  and k.stadium  = 1\n" +
                "  INNER JOIN tb_tvchannels AS tv ON tv.id=k.channels\n" +
                "  and k.channels  = 3";

        Cursor c = db.rawQuery(sql, null);
        return c;
    }


    public Cursor getMatchesByDayList(String now) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT         \n" +
                "k.type as 'type',\n" +
                "k.date as 'date',\n" +
                "k.finished as 'finished',\n" +
                "m1.name as 'home_team', m2.name as 'away_team',\n" +
                "f1.flag as 'home_team_flag' , f2.flag as 'away_team_flag',\n" +
                "s1.city as 'city',s2.lat as 'lat' ,s3.lng  as 'lng',\n" +
                "tv.name as 'channels'\n" +
                "FROM tb_matches as k\n" +
                "INNER JOIN tb_teames AS m1 ON m1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS m2 ON m2.id=k.away_team\n" +
                "INNER JOIN tb_teames AS f1 ON f1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS f2 ON f2.id=k.away_team\n" +
                "INNER JOIN tb_stadiums AS s1 ON s1.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s2 ON s2.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s3 ON s3.id=k.stadium\n" +
                "INNER JOIN tb_tvchannels AS tv ON tv.id=k.channels\n" +
                " and k.day  ='"+now+"' ";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    public Cursor getCommingMatches() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT         \n" +
               " k.id as 'id',"+
                "k.type as 'type',\n" +
                "k.date as 'date',\n" +
                "k.finished as 'finished',\n" +
                "m1.name as 'home_team', m2.name as 'away_team',\n" +
                "f1.flag as 'home_team_flag' , f2.flag as 'away_team_flag',\n" +
                "s1.city as 'city',s2.lat as 'lat' ,s3.lng  as 'lng',\n" +
                "tv.name as 'channels'\n" +
                "FROM tb_matches as k\n" +
                "INNER JOIN tb_teames AS m1 ON m1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS m2 ON m2.id=k.away_team\n" +
                "INNER JOIN tb_teames AS f1 ON f1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS f2 ON f2.id=k.away_team\n" +
                "INNER JOIN tb_stadiums AS s1 ON s1.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s2 ON s2.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s3 ON s3.id=k.stadium\n" +
                "INNER JOIN tb_tvchannels AS tv ON tv.id=k.channels\n" +
                " and k.finished  = 0";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
    public Cursor getFinishedMatches() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT         \n" +
                "k.type as 'type',\n" +
                "k.date as 'date',\n" +
                "k.finished as 'finished',\n" +
                "m1.name as 'home_team', m2.name as 'away_team',\n" +
                "f1.flag as 'home_team_flag' , f2.flag as 'away_team_flag',\n" +
                "s1.city as 'city',s2.lat as 'lat' ,s3.lng  as 'lng',\n" +
                "tv.name as 'channels'\n" +
                "FROM tb_matches as k\n" +
                "INNER JOIN tb_teames AS m1 ON m1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS m2 ON m2.id=k.away_team\n" +
                "INNER JOIN tb_teames AS f1 ON f1.id=k.home_team \n" +
                "INNER JOIN tb_teames AS f2 ON f2.id=k.away_team\n" +
                "INNER JOIN tb_stadiums AS s1 ON s1.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s2 ON s2.id=k.stadium\n" +
                "INNER JOIN tb_stadiums AS s3 ON s3.id=k.stadium\n" +
                "INNER JOIN tb_tvchannels AS tv ON tv.id=k.channels\n" +
                " and k.finished  =1 ";
        Cursor c = db.rawQuery(sql, null);
        return c;
    }
}
