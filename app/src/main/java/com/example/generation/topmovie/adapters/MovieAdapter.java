package com.example.generation.topmovie.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.example.generation.topmovie.MovieDetailActivity;
import com.example.generation.topmovie.R;
import com.example.generation.topmovie.objects.Movie;


import java.util.List;

/**
 * Created by gENERATION on 11.06.2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    //// TODO: 11.06.2017 получить список фильмов

    private Movie [] movieList;
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setMovieList(Movie[] movieList) {
        this.movieList = movieList;
    }

    public MovieAdapter(Movie[] movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context mContext=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.movie_item,parent,false);
        MovieAdapterViewHolder viewHolder=new MovieAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {
        Movie movie=movieList[position];
        ImageView imageView=holder.imageView;

        Glide.with(context)
                .load(movie.getUrlOfImage())
                .placeholder(R.drawable.ic_cloud_off)
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.length;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView imageView;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);
            imageView =(ImageView)itemView.findViewById(R.id.iv_item);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                Movie temp=movieList[position];
                Intent intent= new Intent(context, MovieDetailActivity.class);
                intent.putExtra(MovieDetailActivity.EXTRA_MOVIE_IMAGE,temp);
                context.startActivity(intent);
            }

        }
    }


}
