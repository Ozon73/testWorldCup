package com.example.ibrahim.testworldcup.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ibrahim.testworldcup.R;
import com.example.ibrahim.testworldcup.model.Stadiums;
import com.example.ibrahim.testworldcup.model.Teams;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ibrahim on 14/04/18.
 */

public class StadiumsAdapter { /*extends RecyclerView.Adapter<StadiumsAdapter.MyHoder> {
    List<Stadiums> list;
    Context context;

    AlertDialog.Builder builder;

    public StadiumsAdapter (List<Stadiums> list, Context context) {
        super();
        this.context=context;
        this.list=list;
    }


    @Override
    public StadiumsAdapter.MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.list_item_main, parent, false);
        view.setLayoutParams(new RecyclerView.LayoutParams( RecyclerView.LayoutParams.
                MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));

        StadiumsAdapter.MyHoder holder = new StadiumsAdapter.MyHoder (view);
        return holder;
    }


    @Override
    public void onBindViewHolder(final StadiumsAdapter.MyHoder holder, int position) {
        final Stadiums SH = list.get(position);

        holder.id.setText( String.valueOf(SH.getId ()));
        holder.name.setText(SH.getName ());
        holder.lat.setText(String.valueOf(SH.getLat()));
        holder.lang.setText(String.valueOf(SH.getLng ()));

        holder.city.setText(SH.getCity ());



    }

    @Override
    public int getItemCount()
    {
        if(list!=null){
            return list.size();

        }
        return 0 ;

    }

    class MyHoder extends RecyclerView.ViewHolder{

        TextView id,name,city,lat,lang;
        CircleImageView flag;
        LinearLayout lineTeam;


        public MyHoder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.ids);
            name = (TextView) itemView.findViewById (R.id.namest);
            city = (TextView) itemView.findViewById (R.id.city);
            lat = (TextView) itemView.findViewById (R.id.lat);
            lang = (TextView) itemView.findViewById (R.id.lang);




        }
    }*/

}

