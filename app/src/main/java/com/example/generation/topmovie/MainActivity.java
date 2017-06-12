package com.example.generation.topmovie;

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
    MovieAdapter movieAdapter=new MovieAdapter(this);
    JSONObject jsonObject = new JSONObject();
    static Movie [] movies;
    String s="popular";
    String URL="http://api.themoviedb.org/3/movie/"+s+"?api_key=3e6addce8a705c313a389e1a6c58a113";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Request(URL);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,2);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_movie);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieAdapter);

    }

    private void Request(String url) {
        RequestQueue queue= Volley.newRequestQueue(this);

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonObject = response;
                movies=ParseJSonArray(jsonObject);
                movieAdapter.setMovieList(movies);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println( error.getMessage());

            }
        });
        queue.add(request);
    }

    private Movie [] ParseJSonArray(JSONObject o) {
        JSONArray array=null;
        try {
            array=o.getJSONArray("results");
            System.out.println("GOT IT");
        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("NOT");
        }

        Movie [] movies=new Movie[array.length()];
        for (int i = 0; i <array.length() ; i++) {
            try {
                movies[i]=new Movie((JSONObject) array.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return movies;
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
                s="popular";
                Request(URL);
                break;
            case R.id.menu_item_id_latest:
                s="top_rated";
                Request(URL);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
