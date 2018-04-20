package com.example.ibrahim.testworldcup.Fragmnets;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ibrahim.testworldcup.Adapters.TeamAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Teams;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class TapFragmentTeams extends Fragment {
    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Teams> list;
    RecyclerView recycle;
    TeamAdapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_teams, container, false);

      /*  database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();
        list=new ArrayList<> ();

        recycle = (RecyclerView)rootView. findViewById( R.id.RV_teams);
        recycle.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager (getActivity ());
        recycle.setLayoutManager(recyclerViewlayoutManager);
      //  recyclerViewadapter = new TeamAdapter (list,getActivity () );

        myRef.child ("matches").addValueEventListener (new ValueEventListener () {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot :dataSnapshot.getChildren ()){
                    Teams teams=snapshot.getValue (Teams.class);
                    list.add (teams);
                    recycle.setAdapter(recyclerViewadapter);
                    recyclerViewadapter.notifyDataSetChanged ();


                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });
*/


        return rootView;

    }
}