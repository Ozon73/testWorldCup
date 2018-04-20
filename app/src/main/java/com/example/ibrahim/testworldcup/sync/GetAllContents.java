package com.example.ibrahim.testworldcup.sync;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.network.BaseApiService;
import com.example.ibrahim.testworldcup.network.UtilsApi;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.ibrahim.testworldcup.data.Contract.URL_SYNC;

/**
 * Created by ibrahim on 26/12/17.
 */
public class GetAllContents {
    private static final String TAG = GetAllContents.class.getSimpleName ();
    FirebaseDatabase database;
    DatabaseReference myRef ;
    long away_result;
    long home_result;
    public GetAllContents (FirebaseDatabase database, DatabaseReference myRef) {
        this.database = database;
        this.myRef = myRef;
    }

    private RequestQueue requestQueue;
    DBHelber mDbHelber;
    BaseApiService mApiService;
    Context context;
    public GetAllContents (Context context) {
        this.context = context;
        mDbHelber = new DBHelber ( context );
        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();

    }


    public void getFBStaduims(Context context) {
        myRef.child ("stadiums").child ("stadiums").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    long id= snapshot.child("id").getValue(long.class);
                    String city = snapshot.child("city").getValue(String.class);
                    String ar_city = snapshot.child("ar_city").getValue(String.class);
                    double lat = snapshot.child("lat").getValue(double.class);
                    double lng = snapshot.child("lng").getValue(double.class);
                    String name= snapshot.child("name").getValue(String.class);
                    mDbHelber.addStadiumsList(id,  city,ar_city, lat, lng, name);
                    Log.d (TAG, "value from firbaser : \n id" + id + "\n city :" + city);
                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });


    }
    public void getFBSTvChannel(Context context) {
        myRef.child ("tvchannels").child ("tvchannels").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    long id= snapshot.child("id").getValue(long.class);
                    String name = snapshot.child("name").getValue(String.class);
                    String icon = snapshot.child("icon").getValue(String.class);
                    mDbHelber.addChannelsList (id,  name, icon);
                    Log.d (TAG, "value from firbaser : \n id" + id + "\n city :" + name);
                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });


    }

    public void getFBSTeams(Context context) {
        myRef.child ("teams").child ("teams").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        long id = snapshot.child ("id").getValue (long.class);
                    long po = snapshot.child ("po").getValue (long.class);
                    long res = snapshot.child ("res").getValue (long.class);
                        String name = snapshot.child ("name").getValue (String.class);
                    String ar_name = snapshot.child ("ar_name").getValue (String.class);

                    String flag = snapshot.child ("flag").getValue (String.class);
                        String iso2 = snapshot.child ("iso2").getValue (String.class);

                        mDbHelber.addTeamsList (id,po,res,  name,ar_name,flag, iso2);
                        Log.d (TAG, "value from firbaser : \n id" + id + "\n city :" + name);


                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });
    }
    public void getFBSGroups(Context context) {
        myRef.child ("group").child ("group").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    long id= snapshot.child("id").getValue(long.class);
                    String name= snapshot.child("name").getValue(String.class);
                    long t1= snapshot.child("team1").getValue(long.class);
                    long t2= snapshot.child("team2").getValue(long.class);
                    long t3= snapshot.child("team3").getValue(long.class);
                    long t4= snapshot.child("team4").getValue(long.class);


                    mDbHelber.addGroupList ( id,  name, t1, t2, t3, t4);
                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });


    }
    public void getFBSMatches(Context context) {
        myRef.child ("matches").child ("matches").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                   long id= snapshot.child("id").getValue(long.class);
                    long nam= snapshot.child("name").getValue(long.class);

                    String type = snapshot.child("type").getValue(String.class);
                    long home_team= snapshot.child("home_team").getValue(long.class);
                    long away_team= snapshot.child("away_team").getValue(long.class);
                    if(snapshot.child("home_result").getValue(long.class)!=null){
                        home_result= snapshot.child("home_result").getValue(long.class);
                    }else if(snapshot.child("away_result").getValue(long.class)!=null){
                        away_result= snapshot.child("away_result").getValue(long.class);
                    }
                    String date = snapshot.child("date").getValue(String.class);
                    String day = snapshot.child("today").getValue(String.class);
                    long stadium= snapshot.child("stadium").getValue(long.class);
                    long channels=3;// snapshot.child("channels").getValue(long.class);
                    boolean finished = snapshot.child("finished").getValue(boolean.class);

                    mDbHelber.addMathesList (  id, nam,type,  home_team,away_team,  home_result, away_result, date,day,  stadium, channels,  finished);
                //    Log.d (TAG, "value from firbaser : \n id" + id + "\n city :" + away_team);
                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });


    }
    public void getMatches(Context context) {

        StringRequest stringRequest = new StringRequest ( Request.Method.POST, URL_SYNC ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //       JSONObject jObj = new JSONObject(response);

                            JSONArray jsonArray = new JSONArray( response );

                            PARSE_STATES( jsonArray );
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        } ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String> ();
                params.put("finished", "yes");

                return params;
            }
        };
        requestQueue = Volley.newRequestQueue( context );
        requestQueue.add( stringRequest );
    }

    public void PARSE_STATES(JSONArray array) {
        for (int i = 0; i < array.length (); i++) {
            JSONObject json = null;
            try {
                json = array.getJSONObject (i);

                String TeamA = json.getString ("TeamA");
                String TeamB = json.getString ("TeamB");

                //      mDbHelber.addMathesList (TeamA, TeamB);

                Log.d (TAG, "value from face server : \n TeamA" + TeamA + "\n TeamB :" + TeamB);

            } catch (JSONException e) {
                e.printStackTrace ();
                Log.d (TAG, "JSONException bbbb" + e.getMessage ());

            }
        }
    }
}
