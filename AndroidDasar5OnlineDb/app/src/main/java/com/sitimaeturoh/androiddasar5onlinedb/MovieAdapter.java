package com.sitimaeturoh.androiddasar5onlinedb;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sitimaeturoh.androiddasar5onlinedb.model.ResultsItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViwHolder> {

    public static final String DATA_EXTRA =  "dataextra";
    private Context context;
    private List<ResultsItem> data = new ArrayList<>();
    public static String DATA_MOVIE = "datamovie";

    //constructor
    //klik kanan > generate > constructor

    public MovieAdapter(Context context, List<ResultsItem> data) {
        this.context = context;
        this.data = data;

    }

    //menyambungkan layout item
    @NonNull
    @Override
    public MyViwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup, false);
        return new MyViwHolder(itemView);
    }
    //set data
    @Override
    public void onBindViewHolder(@NonNull MyViwHolder myViwHolder, final int posisi) {
    myViwHolder.tvJudul.setText(data.get(posisi).getTitle());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+data.get(posisi).getPosterPath()).into(myViwHolder.ivPoster);
        myViwHolder.itemView.setOnClickListener(new View.OnClickListener() {
            

            @Override
            public void onClick(View v) {
                Intent i = new Intent( context, DetailMovieActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelable(DATA_MOVIE, Parcels.wrap( data.get(posisi)));
                i.putExtra(DATA_EXTRA, bundle);
                context.startActivity(i);
            }
        });
    }
    //jumlah data
    @Override
    public int getItemCount() {
        return data.size();
    }
    //mengenalkan komponen dalam item
    public class MyViwHolder extends RecyclerView.ViewHolder {
        TextView tvJudul;
        ImageView ivPoster;
        public MyViwHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            ivPoster = itemView.findViewById(R.id.iv_item_gambar);
        }
    }

    //extend class ini
    //alt+enter smpai meragnya hilang
}
