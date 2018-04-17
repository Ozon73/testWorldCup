package com.example.ibrahim.testworldcup.Fragmnets;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahim.testworldcup.Adapters.MatchesAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.model.Matches;

import java.util.ArrayList;
import java.util.List;

import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.AWAY_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.CHANNELS;
import static com.example.ibrahim.testworldcup.data.Contract.CITY;
import static com.example.ibrahim.testworldcup.data.Contract.DATE;
import static com.example.ibrahim.testworldcup.data.Contract.FINISHED;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM;
import static com.example.ibrahim.testworldcup.data.Contract.HOME_TEAM_FLAG;
import static com.example.ibrahim.testworldcup.data.Contract.ID;
import static com.example.ibrahim.testworldcup.data.Contract.LAT;
import static com.example.ibrahim.testworldcup.data.Contract.LNG;
import static com.example.ibrahim.testworldcup.data.Contract.TYPE;

public class TabFragmentLast  extends Fragment {
    private List<Matches> matches ;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    DBHelber mDbHelber;
    RecyclerView RV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_last, container, false);

        mDbHelber=new DBHelber( getActivity () );
        matches=new ArrayList<> ();
        RV = (RecyclerView) rootView.findViewById( R.id.RV_finished);
        RV.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (getActivity ());
        RV.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new MatchesAdapter (matches,getActivity ());
        RV.setAdapter(recyclerViewadapter);
        recyclerViewadapter.notifyDataSetChanged();
        displayOfline();
        return rootView;

    }
    private void displayOfline(){
        matches.clear();
        Cursor cursor = mDbHelber.getFinishedMatches ( );
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

        }}
}