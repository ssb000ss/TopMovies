package com.example.generation.topmovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.generation.topmovie.adapters.MovieAdapter;
import com.example.generation.topmovie.objects.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    JSONArray jsonArray = new JSONArray();
    Movie []movies;
    String s="top_rated";
    String URL="http://api.themoviedb.org/3/movie/"+s+"?api_key=3e6addce8a705c313a389e1a6c58a113";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final JSONObject[] jsonArray = {null};

        RequestQueue queue= Volley.newRequestQueue(this);

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonArray[0] = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);

        try {
            JSONArray array=jsonArray[0].getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(layoutManager);
        MovieAdapter movieAdapter=new MovieAdapter(movies,this);
        recyclerView.setAdapter(movieAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.menu_item_id_pop:
                startActivity(new Intent(MainActivity.this, MovieDetailActivity.class));
                break;
            case R.id.menu_item_id_latest:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
