package com.example.ibrahim.testworldcup.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.data.DBHelber;
import com.example.ibrahim.testworldcup.model.Matches;
import com.example.ibrahim.testworldcup.sync.GetAllContents;
import com.example.ibrahim.testworldcup.ui.MainActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 28/06/2017.
 */

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MyHolder> {
    private static final String TAG = "MatchesAdapter";

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Matches> matches;
    Context context;
    AlertDialog.Builder builder;
    String temaName;

    public MatchesAdapter (List<Matches> matches, Context context) {
        super();
        this.context=context;
        this.matches=matches;
    }



    /* public CommentAdapter(List<ListComments> mylist) {
     }
 */


    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_main, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        final Matches SH = matches.get(position);

        holder.away_team.setText(SH.getAway_team ());
       holder.home_team.setText(SH.getHome_team ());
  //      holder.away_result.setText(String.valueOf (SH.getAway_result ()));
    //    holder.home_result.setText(String.valueOf (SH.getHome_result ()));
        holder.date.setText(SH.getDate ());
        holder.stadium.setText(SH.getCity ());
        //holder.finished.setText(SH.getAway_team ());
        //holder.type.setText(SH.getHome_team ());
        Picasso.get().load(SH.getHome_team_flag ()).into(holder.home_team_flag);
        Picasso.get().load(SH.getAway_team_flag ()).into(holder.away_team_flag);
     //   TakePhotoClicked,txtCancel,txtOk
        database = FirebaseDatabase.getInstance();
        myRef=database.getReference ();
        holder.idfromsqlite.setText (String.valueOf(SH.getId ()));

        myRef = FirebaseDatabase.getInstance().getReference().child("matches").child("matches");
        myRef.child(String.valueOf (SH.getId ())).addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                try {
                    long id= dataSnapshot.child("id").getValue(long.class);
                    holder.idfromfire.setText (String.valueOf(id));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onCancelled (DatabaseError databaseError) {

            }
        });

        holder.btnHome.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                notficationBuild();
                final Dialog dialog = new Dialog (context, R.style.AppTheme_Dark_Dialog);
                dialog.setContentView (R.layout.adapter_dialoge);
                final EditText etEditValue=dialog.findViewById (R.id.etEditValue);
                TextView txtubdate=dialog.findViewById (R.id.txtubdate);
                txtubdate.setText (SH.getHome_team ());
                database = FirebaseDatabase.getInstance();
                myRef=database.getReference ();
                final String getVal= String.valueOf (SH.getId ());
             dialog.findViewById (R.id.txtOk)
                        .setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick (View v) {
                                long newVlue= Long.parseLong (etEditValue.getText ().toString ());
                                String idTeam=null;
                                long  addGoals=0;

                                try {
                                    myRef.child("matches").child("matches").child(getVal.trim ()).child("home_result").setValue(newVlue);
                                    DBHelber dbHelber=new DBHelber (context);
                                    GetAllContents getAllContents=new GetAllContents (context);
                                    dbHelber.addGoals(Long.parseLong (getVal));
                                      addGoals=dbHelber.getHomeResult(SH.getId ());
                              //      holder .idfromfire.setText (addGoals);
                                     idTeam=String.valueOf (dbHelber.getIdTeamByName (SH.getHome_team ().trim ()));
                                    myRef.child("teams").child("teams").child(idTeam).child("res").setValue(addGoals);
                                    getAllContents.getFBSMatches (context);
                                    getAllContents.getFBSTeams (context);



                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                                FirebaseMessaging.getInstance().subscribeToTopic("news");
                                // [END subscribe_topics]

                                // Log and toast
                                String msg = context.getString(R.string.msg_subscribed);
                                Log.d(TAG, msg);
                                Toast.makeText (context,String.valueOf (addGoals),Toast.LENGTH_LONG).show ();

                               // Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                                dialog.dismiss ();

                            }
                        });
                dialog.findViewById (R.id.txtCancel)
                        .setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick (View v) {
                                dialog.dismiss ();
                            }
                        });
                dialog.show ();
            }
        });
        holder.btnAway.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                final Dialog dialog = new Dialog (context, R.style.AppTheme_Dark_Dialog);
                dialog.setContentView (R.layout.adapter_dialoge);
                final EditText etEditValue=dialog.findViewById (R.id.etEditValue);
                final TextView txtubdate=dialog.findViewById (R.id.txtubdate);
                txtubdate.setText (SH.getAway_team ());
                database = FirebaseDatabase.getInstance();
                myRef=database.getReference ();
                final String getVal= String.valueOf (SH.getId ());
                dialog.findViewById (R.id.txtOk)
                        .setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick (View v) {
                                notficationBuild();
                                long newVlue= Long.parseLong (etEditValue.getText ().toString ());
                                try {
                                    myRef.child("matches").child("matches").child(getVal.trim ()).child("away_result").setValue(newVlue);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                FirebaseMessaging.getInstance().subscribeToTopic("news");
                                // [END subscribe_topics]

                                // Log and toast
                                String msg = context.getString(R.string.msg_subscribed);
                                Log.d(TAG, msg);
                                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

                                dialog.dismiss ();

                            }
                        });
                dialog.findViewById (R.id.txtCancel)
                        .setOnClickListener (new View.OnClickListener () {
                            @Override
                            public void onClick (View v) {
                                dialog.dismiss ();
                            }
                        });
                dialog.show ();
            }
        });

    }
    @Override
    public int getItemCount()
    {
        if(matches!=null){
            return matches.size();

        }
        return 0 ;

    }


    public void notficationBuild(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create channel to show notifications.
            String channelId  = context.getString(R.string.default_notification_channel_id);
            String channelName = context.getString(R.string.default_notification_channel_name);
            NotificationManager notificationManager =
                    context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel (channelId,
                    channelName, NotificationManager.IMPORTANCE_LOW));


            if (((Activity)context).getIntent().getExtras() != null) {
                for (String key : ((Activity)context).getIntent().getExtras().keySet()) {
                    Object value = ((Activity)context).getIntent().getExtras().get(key);
                    Log.d(TAG, "Key: " + key + " Value: " + value);
                }
            }
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {



    private     TextView away_team;
        private TextView home_team;
      private   TextView date;
       private TextView stadium;
       private TextView away_result;
        private TextView home_result;
        private TextView idfromfire,idfromsqlite;
        private CircleImageView home_team_flag,away_team_flag;
        private Button btnHome,btnAway;

        private LinearLayout lin_result,linecompare;

        MyHolder (View view) {
            super (view);
            away_team = (TextView) view.findViewById (R.id.away_team);
            home_team = (TextView) view.findViewById (R.id.home_team);
            date = (TextView) view.findViewById (R.id.date_m);
            stadium = (TextView) view.findViewById (R.id.stadium_m);
            away_result = (TextView) view.findViewById (R.id.away_result);
            home_result = (TextView) view.findViewById (R.id.home_result);
            idfromfire = (TextView) view.findViewById (R.id.idfromfire);
            idfromsqlite = (TextView) view.findViewById (R.id.ifromsqlite);

            home_team_flag = view.findViewById (R.id.home_team_flag);
            away_team_flag = view.findViewById (R.id.away_team_flag);

            lin_result = view.findViewById (R.id.lin_result);
            linecompare = view.findViewById (R.id.linecompare);
            btnHome = view.findViewById (R.id.btnHome);
            btnAway = view.findViewById (R.id.btnAway);



        }

    } }