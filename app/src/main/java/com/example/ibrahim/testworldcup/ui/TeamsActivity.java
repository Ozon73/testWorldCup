package com.example.ibrahim.testworldcup.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ibrahim.testworldcup.Adapters.TeamAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.model.Teams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.ibrahim.testworldcup.data.Contract.AR_NAME;
import static com.example.ibrahim.testworldcup.data.Contract.DATE_FORMAT_NOW;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.ID;
import static com.example.ibrahim.testworldcup.data.Contract.ISO2;
import static com.example.ibrahim.testworldcup.data.Contract.NAME;
import static com.example.ibrahim.testworldcup.data.Contract.POINT;
import static com.example.ibrahim.testworldcup.data.Contract.RESULT;

public class TeamsActivity extends AppCompatActivity {
    private static final String TAG = TeamsActivity.class.getSimpleName ();

    List<Teams> list;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    DBHelber mDbHelber;
    RecyclerView RV;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_teams);
        mDbHelber=new DBHelber ( this );
        list=new ArrayList<> ();
        RV = (RecyclerView) findViewById( R.id.RV_teams);
        RV.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (this);
        RV.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new TeamAdapter (list,this);
        RV.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();
        displayOfline();


    }
    private void displayOfline(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat(DATE_FORMAT_NOW);
        String strDate =  mdformat.format(calendar.getTime());
        Log.v(TAG,"naw aday:\n"+strDate);

        list.clear();
        Cursor cursor = mDbHelber.getTeamList();
        while (cursor.moveToNext()) {
            Teams list2;
            list2 = new Teams (
                    cursor.getLong ( cursor.getColumnIndex( ID ) ),
                    cursor.getString( cursor.getColumnIndex( NAME ) ),
                    cursor.getString( cursor.getColumnIndex( AR_NAME )),
                    cursor.getLong ( cursor.getColumnIndex( RESULT ) ),
                    cursor.getLong ( cursor.getColumnIndex( POINT ) ),
                    cursor.getString( cursor.getColumnIndex( FLAG ) ),
                    cursor.getString( cursor.getColumnIndex( ISO2 ) ));

            list.add( list2 );

        }}
}
