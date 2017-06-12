package com.example.generation.topmovie;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.generation.topmovie.R;
import com.example.generation.topmovie.objects.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE_IMAGE="MovieDetailActivity.MOVIE_IMAGE";

    TextView title;
    TextView release_date;
    ImageView image;
    RatingBar rating;
    WebView overview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        title=(TextView) findViewById(R.id.tv_detail_title);
        release_date=(TextView) findViewById(R.id.tv_detail_release_date);
        image=(ImageView) findViewById(R.id.iv_detail_image);
        rating=(RatingBar) findViewById(R.id.rb_detail);
        overview=(WebView) findViewById(R.id.tv_detail_overview);

        Movie movie=getIntent().getParcelableExtra(EXTRA_MOVIE_IMAGE);

        title.setText(movie.getTitle());
        release_date.setText(movie.getRelease_date());
        rating.setRating(movie.getVote_average());
        overview.loadData(movie.getOverview(), "text/html; charset=utf-8", "UTF-8");

        Glide.with(this)
                .load(movie.getUrlOfPoster())
                .asBitmap()
                .error(R.drawable.ic_fullscreen)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(image);
    }
}
