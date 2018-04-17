package com.example.ibrahim.testworldcup.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.ibrahim.testworldcup.Adapters.PagerAdapter;
import com.example.ibrahim.testworldcup.Adapters.TeamAdapter;
import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Teams;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.ValueEventListener;

public class MatchesActiviy extends AppCompatActivity {

    FirebaseDatabase database;

    DatabaseReference myRef ;
    List<Teams> list;
    RecyclerView recycle;
    TeamAdapter recyclerAdapter;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter  recyclerViewadapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_mathes_activiy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    /*    database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();
        list=new ArrayList<> ();

        recycle = (RecyclerView) findViewById( R.id.RV_teams);
        recycle.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager ( this);
        recycle.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new TeamAdapter (list, this );

        myRef.child ("teams").addValueEventListener (new ValueEventListener () {

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

       TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Coming"));
        tabLayout.addTab(tabLayout.newTab().setText(" Finished"));
        tabLayout.addTab(tabLayout.newTab().setText("Teams"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}