package nyc.c4q.rafaelsoto.nowfeed;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;
import nyc.c4q.rafaelsoto.nowfeed.models.geolocation.GeoLocation;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.Result;
import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.TmdbData;
import nyc.c4q.rafaelsoto.nowfeed.models.youtube.YoutubeItem;
import nyc.c4q.rafaelsoto.nowfeed.networks.darksky.DarkSkyClient;
import nyc.c4q.rafaelsoto.nowfeed.networks.geolocation.GeoLocationClient;
import nyc.c4q.rafaelsoto.nowfeed.networks.newsapi.NewsApiClient;
import nyc.c4q.rafaelsoto.nowfeed.networks.tmdb.TmdbApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GeoLocationClient geoLocation;
    private DarkSkyClient darkSkyClient;
    private NewsApiClient newsApiClient;
    private TmdbApiClient tmdbApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView animImageView = (ImageView) findViewById(R.id.header_view);
        animImageView.setBackgroundResource(R.drawable.anim);
        animImageView.setImageAlpha(5);
        animImageView.post(new Runnable() {
            @Override
            public void run() {
                AnimationDrawable frameAnimation =
                        (AnimationDrawable) animImageView.getBackground();
                frameAnimation.start();
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CardAdapter());

        initYoutubeCard();
        initGeoLocation(); //will also call initWeatherCard within
        createNewsCards();
        createMovieCards();
    }

    private void initYoutubeCard() {
        CardAdapter cardAdapter = (CardAdapter) recyclerView.getAdapter();
        cardAdapter.addToDataList(new YoutubeItem("youtube placeholder for the card adapter"));
    }


    private void initGeoLocation() {
        geoLocation = GeoLocationClient.getInstance();
        Call<GeoLocation> call = geoLocation.getLocation();
        call.enqueue(new Callback<GeoLocation>() {
            @Override
            public void onResponse(Call<GeoLocation> call, Response<GeoLocation> response) {
                GeoLocation location = response.body();
                String latLon = location.getLat() + ", " + location.getLon();
                initWeatherCard(latLon);
            }

            @Override
            public void onFailure(Call<GeoLocation> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting location data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initWeatherCard(String latLon) {
        darkSkyClient = DarkSkyClient.getInstance();
        Call<Forecast> call = darkSkyClient.getForecast(latLon); //Fixed lat, lon but will revise later
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body(); //Get object from response.body in my case the api returns a Forecast object
                CardAdapter cardAdapter = (CardAdapter) recyclerView.getAdapter(); //Get reference to cardAdapter from the recyclerView
                cardAdapter.addToDataList(forecast); //Add the Forecast object to the data list in the adapter (first card)
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting weather data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void createNewsCards() {
        newsApiClient = NewsApiClient.getInstance();
        Call<NewsFeed> call = newsApiClient.getArticles("the-next-web", "latest");
        call.enqueue(new Callback<NewsFeed>() {
            @Override
            public void onResponse(Call<NewsFeed> call, Response<NewsFeed> response) {
                NewsFeed newsFeed = response.body();
                CardAdapter cardAdapter = (CardAdapter) recyclerView.getAdapter();
                cardAdapter.addToDataList(newsFeed);
            }

            @Override
            public void onFailure(Call<NewsFeed> call, Throwable t) {

                Toast.makeText(getBaseContext(), "Error getting data from News-API.Org.", Toast.LENGTH_SHORT).show();

            }

        });
    }

    private void createMovieCards() {
        tmdbApiClient = TmdbApiClient.getInstance();
        Call<TmdbData> call = tmdbApiClient.getResults();
        call.enqueue(new Callback<TmdbData>() {
            @Override
            public void onResponse(Call<TmdbData> call, Response<TmdbData> response) {
                TmdbData tmdbData = response.body();
                CardAdapter cardAdapter = (CardAdapter) recyclerView.getAdapter();
                cardAdapter.addToDataList(tmdbData);
                System.out.println(tmdbData.toString());
            }

            @Override
            public void onFailure(Call<TmdbData> call, Throwable t) {

                Toast.makeText(getBaseContext(), "Error getting data from TMDB.Org.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
