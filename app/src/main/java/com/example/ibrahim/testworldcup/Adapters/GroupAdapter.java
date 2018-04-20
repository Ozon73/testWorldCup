package com.example.ibrahim.testworldcup.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Groups;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ibrahim on 19/04/18.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.MyHoder> {
    List<Groups> list;
    Context context;

    AlertDialog.Builder builder;

    public GroupAdapter (List<Groups> list, Context context) {
        super ();
        this.context = context;
        this.list = list;
    }


    @Override
    public GroupAdapter.MyHoder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.list_item_group, parent, false);
        view.setLayoutParams (new RecyclerView.LayoutParams (RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        GroupAdapter.MyHoder holder = new GroupAdapter.MyHoder (view);
        return holder;
    }


    @Override
    public void onBindViewHolder (final GroupAdapter.MyHoder holder, int position) {
        final Groups SH = list.get (position);

        holder.name.setText (SH.getName ());

        holder.team1.setText (SH.getTeam1 ());
        holder.team2.setText (SH.getTeam2 ());
        holder.team3.setText (SH.getTeam3 ());
        holder.team4.setText (SH.getTeam4 ());

        holder.pointG1.setText (String.valueOf (SH.getPo1 ()));
        holder.pointG2.setText (String.valueOf (SH.getPo2 ()));
        holder.pointG3.setText (String.valueOf (SH.getPo3 ()));
        holder.pointG4.setText (String.valueOf (SH.getPo4 ()));

        holder.goalsG1.setText (String.valueOf (SH.getRes1 ()));
        holder.goalsG2.setText (String.valueOf (SH.getRes2 ()));
        holder.goalsG3.setText (String.valueOf (SH.getRes3 ()));
        holder.goalsG4.setText (String.valueOf (SH.getRes4 ()));

        Picasso.get ().load (SH.getFlag1 ()).into (holder.flagG1);
        Picasso.get ().load (SH.getFlag2 ()).into (holder.flagG2);
        Picasso.get ().load (SH.getFlag3 ()).into (holder.flagG3);
        Picasso.get ().load (SH.getFlag4 ()).into (holder.flagG4);

    }

    @Override
    public int getItemCount () {
        if (list != null) {
            return list.size ();

        }
        return 0;

    }

    class MyHoder extends RecyclerView.ViewHolder {

        private TextView name;
      private  TextView pointG1,pointG2, pointG3, pointG4;
      private TextView goalsG1,goalsG2, goalsG3, goalsG4;
      private TextView team1,team2,team3,team4;
      private CircleImageView flagG1,flagG2,flagG3,flagG4;

        public MyHoder (View itemView) {
            super (itemView);

            name = (TextView) itemView.findViewById (R.id.groupName);

            pointG1 = (TextView) itemView.findViewById (R.id.pointG1);
            pointG2 = (TextView) itemView.findViewById (R.id.pointG2);
            pointG3 = (TextView) itemView.findViewById (R.id.pointG3);
            pointG4 = (TextView) itemView.findViewById (R.id.pointG4);

            goalsG1 = (TextView) itemView.findViewById (R.id.goalsG1);
            goalsG2 = (TextView) itemView.findViewById (R.id.goalsG2);
            goalsG3= (TextView) itemView.findViewById (R.id.goalsG3);
            goalsG4 = (TextView) itemView.findViewById (R.id.goalsG4);

            team1 = (TextView) itemView.findViewById (R.id.team1);
            team2 = (TextView) itemView.findViewById (R.id.team2);
            team3= (TextView) itemView.findViewById (R.id.team3);
            team4= (TextView) itemView.findViewById (R.id.team4);
            team1 = (TextView) itemView.findViewById (R.id.team1);

            flagG1 = (CircleImageView) itemView.findViewById (R.id.flagG1);
            flagG2 = (CircleImageView) itemView.findViewById (R.id.flagG2);
            flagG3= (CircleImageView) itemView.findViewById (R.id.flagG3);
            flagG4= (CircleImageView) itemView.findViewById (R.id.flagG4);



        }
    }

}


