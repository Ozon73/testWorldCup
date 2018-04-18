package com.example.ibrahim.testworldcup.ui;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.Adapters.MatchesAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.data.SharedPrefManager;
import com.example.ibrahim.testworldcup.model.Matches;
import com.example.ibrahim.testworldcup.sync.GetAllContents;
import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.CITY;
import static com.example.ibrahim.testworldcup.data.Contract.DATE;
import static com.example.ibrahim.testworldcup.data.Contract.DATE_FORMAT_NOW;
import static com.example.ibrahim.testworldcup.data.Contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.ID;
import static com.example.ibrahim.testworldcup.data.Contract.LAT;
import static com.example.ibrahim.testworldcup.data.Contract.LNG;
import static com.example.ibrahim.testworldcup.data.Contract.TYPE;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName ();

    private List<Matches> matches ;
    GetAllContents getAllContents;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    DBHelber mDbHelber;
    RecyclerView RV;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);



        getAllContents=new GetAllContents (this);
        getAllContents.getFBStaduims (this);
        getAllContents.getFBSTvChannel (this);
        getAllContents.getFBSTeams (this);
        getAllContents.getFBSMatches (this);

        TextView ttt=findViewById (R.id.tokentxt);
        ttt.setText (SharedPrefManager.getInstance (this).getDeviceToken ());
        mDbHelber=new DBHelber( this );
        matches=new ArrayList<> ();
        RV = (RecyclerView) findViewById( R.id.RV_main);
        RV.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (this);
        RV.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new MatchesAdapter (matches,this);
        RV.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();
        displayOfline();
        findViewById (R.id.BtnGoMatches).setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent intent = new Intent (MainActivity.this, MatchesActiviy.class);
                startActivity (intent);
            }
        });

    }
    private void displayOfline(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat(DATE_FORMAT_NOW);
        String strDate =  mdformat.format(calendar.getTime());
        Log.v(TAG,"naw aday:\n"+strDate);

        matches.clear();
        Cursor cursor = mDbHelber.getMatchesByDayList(strDate.trim () );
        while (cursor.moveToNext()) {
            Matches matches2;
            matches2 = new Matches(
                    cursor.getLong ( cursor.getColumnIndex( ID ) ),
                    cursor.getString( cursor.getColumnIndex( TYPE ) ),
                   cursor.getString( cursor.getColumnIndex( DATE )),
                    cursor.getString( cursor.getColumnIndex( FINISHED ) ),
                    cursor.getString( cursor.getColumnIndex( HOME_TEAM ) ),
                    cursor.getString( cursor.getColumnIndex( AWAY_TEAM ) ),
                    cursor.getString( cursor.getColumnIndex( HOME_TEAM_FLAG ) ),
                    cursor.getString ( cursor.getColumnIndex( AWAY_TEAM_FLAG ) ),
                    cursor.getString ( cursor.getColumnIndex( CITY )),
                    cursor.getString ( cursor.getColumnIndex( LAT )),
                    cursor.getString ( cursor.getColumnIndex( LNG )),
                    cursor.getString( cursor.getColumnIndex( CHANNELS ) ));

            matches.add( matches2 );

        }
    }

}