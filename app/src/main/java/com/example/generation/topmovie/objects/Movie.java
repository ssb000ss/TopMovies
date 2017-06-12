package com.example.generation.topmovie.objects;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.System.in;

/**
 * Created by gENERATION on 11.06.2017.
 */

public class Movie implements Parcelable{

    String TITLE_KEY="title";
    String RELEASE_DATE_KEY="release_date";
    String VOTE_AVERAGE_KEY="vote_average";
    String OVERVIEW_KEY="overview";
    String URL_JPG_KEY="poster_path";
    String URL_POSTER_KEY="backdrop_path";


    private String title;
    private String release_date;
    private float vote_average;
    private String overview;
    private String urlOfImage;
    private String urlOfPoster;



    public Movie(JSONObject jsonObject) {
        try {
            this.title=jsonObject.getString(TITLE_KEY);
            this.release_date=jsonObject.getString(RELEASE_DATE_KEY);
            this.vote_average= (float) jsonObject.getDouble(VOTE_AVERAGE_KEY);
            this.overview=jsonObject.getString(OVERVIEW_KEY);
            this.urlOfImage= "http://image.tmdb.org/t/p/w780" + jsonObject.getString(URL_JPG_KEY);
            this.urlOfPoster= "http://image.tmdb.org/t/p/w780" + jsonObject.getString(URL_POSTER_KEY);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getUrlOfPoster() {
        return urlOfPoster;
    }

    public void setUrlOfPoster(String urlOfPoster) {
        this.urlOfPoster = urlOfPoster;
    }

    protected Movie(Parcel in) {
        title=in.readString();
        release_date=in.readString();
        vote_average=in.readFloat();
        overview=in.readString();
        urlOfImage=in.readString();
        urlOfPoster=in.readString();
    }

    public Movie(String title, String release_date, float vote_average, String overview, String urlOfImage) {
        this.title = title;
        this.release_date = release_date;
        this.vote_average = vote_average;
        this.overview = overview;
        this.urlOfImage = urlOfImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUrlOfImage() {
        return urlOfImage;
    }

    public void setUrlOfImage(String urlOfImage) {
        this.urlOfImage = urlOfImage;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(release_date);
        dest.writeFloat(vote_average);
        dest.writeString(overview);
        dest.writeString(urlOfImage);
        dest.writeString(urlOfPoster);
    }

    public  static  Movie[] getMovies() {
        return new Movie[]{
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/hA5oCgvgCxj5MEWcLpjXXTwEANF.jpg"),
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/2Sns5oMb356JNdBHgBETjIpRYy9.jpg"),
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/gF4PQYOufm5WcQREHegJI7PjsDy.jpg"),
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/jLRllZsubY8UWpeMyDLVXdRyEWi.jpg"),
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/hAPeXBdGDGmXRPj4OZZ0poH65Iu.jpg"),
                new Movie("Doctor Who: The Day of the Doctor", "2008-07-16", (float) 8.2, "In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.", "http://image.tmdb.org/t/p/w780/m55rLpSklCkBmYhhLuZZhhesWFW.jpg")
        };
    }

}
