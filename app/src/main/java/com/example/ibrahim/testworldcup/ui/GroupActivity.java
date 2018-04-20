package com.example.ibrahim.testworldcup.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ibrahim.testworldcup.Adapters.GroupAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.model.Groups;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.ibrahim.testworldcup.data.Contract.DATE_FORMAT_NOW;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG1;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG2;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG3;
import static com.example.ibrahim.testworldcup.data.Contract.FLAG4;
import static com.example.ibrahim.testworldcup.data.Contract.ID;
import static com.example.ibrahim.testworldcup.data.Contract.NAME;
import static com.example.ibrahim.testworldcup.data.Contract.POINT1;
import static com.example.ibrahim.testworldcup.data.Contract.POINT2;
import static com.example.ibrahim.testworldcup.data.Contract.POINT3;
import static com.example.ibrahim.testworldcup.data.Contract.POINT4;
import static com.example.ibrahim.testworldcup.data.Contract.RESULT1;
import static com.example.ibrahim.testworldcup.data.Contract.RESULT2;
import static com.example.ibrahim.testworldcup.data.Contract.RESULT3;
import static com.example.ibrahim.testworldcup.data.Contract.RESULT4;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM1;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM2;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM3;
import static com.example.ibrahim.testworldcup.data.Contract.TEAM4;

public class GroupActivity extends AppCompatActivity {
    private static final String TAG = GroupActivity.class.getSimpleName ();

    List<Groups> list;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;
    DBHelber mDbHelber;
    RecyclerView RV;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_group);
        mDbHelber = new DBHelber (this);
        list = new ArrayList<> ();
        RV = (RecyclerView) findViewById (R.id.RV_group);
        RV.setHasFixedSize (true);
        recyclerViewlayoutManager = new LinearLayoutManager (this);
        RV.setLayoutManager (recyclerViewlayoutManager);
        recyclerViewadapter = new GroupAdapter (list, this);
        RV.setAdapter (recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged ();
        displayOfline ();


    }

    private void displayOfline () {
        Calendar calendar = Calendar.getInstance ();
        SimpleDateFormat mdformat = new SimpleDateFormat (DATE_FORMAT_NOW);
        String strDate = mdformat.format (calendar.getTime ());
        Log.v (TAG, "naw aday:\n" + strDate);

        list.clear ();
        Cursor cursor = mDbHelber.getGroupList ();
        while (cursor.moveToNext ()) {
            Groups list2;
            list2 = new Groups (
                    cursor.getLong (cursor.getColumnIndex (ID)),
                    cursor.getString (cursor.getColumnIndex (NAME)),
                    cursor.getString (cursor.getColumnIndex (TEAM1)),
                    cursor.getString (cursor.getColumnIndex (TEAM2)),
                    cursor.getString (cursor.getColumnIndex (TEAM3)),
                    cursor.getString (cursor.getColumnIndex (TEAM4)),

                    cursor.getString (cursor.getColumnIndex (FLAG1)),
                    cursor.getString (cursor.getColumnIndex (FLAG2)),
                    cursor.getString (cursor.getColumnIndex (FLAG3)),
                    cursor.getString (cursor.getColumnIndex (FLAG4)),
                    cursor.getLong (cursor.getColumnIndex (RESULT1)),
                    cursor.getLong (cursor.getColumnIndex (RESULT2)),
                    cursor.getLong (cursor.getColumnIndex (RESULT3)),
                    cursor.getLong (cursor.getColumnIndex (RESULT4)),

                    cursor.getLong (cursor.getColumnIndex (POINT1)),
                    cursor.getLong (cursor.getColumnIndex (POINT2)),
                    cursor.getLong (cursor.getColumnIndex (POINT3)),
                    cursor.getLong (cursor.getColumnIndex (POINT4)));

            list.add (list2);

        }
    }
}