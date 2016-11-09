package nyc.c4q.rafaelsoto.nowfeed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import nyc.c4q.rafaelsoto.nowfeed.networks.darksky.DarkSkyClient;
import nyc.c4q.rafaelsoto.nowfeed.networks.newsapi.NewsApi;
import nyc.c4q.rafaelsoto.nowfeed.networks.newsapi.NewsApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DarkSkyClient darkSkyClient;
    private NewsApiClient newsApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CardAdapter());

        createWeatherCard();
    }

    public void createWeatherCard() {
        darkSkyClient = DarkSkyClient.getInstance();
        Call<Forecast> call = darkSkyClient.getForecast("70,-40"); //Fixed lat, lon but will revise later
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                Forecast forecast = response.body(); //Get object from response.body in my case the api returns a Forecast object
                CardAdapter cardAdapter = (CardAdapter) recyclerView.getAdapter(); //Get reference to cardAdapter from the recyclerView
                cardAdapter.addToDataList(forecast); //Add the Forecast object to the data list in the adapter (first card)
                cardAdapter.addToDataList(new User("JJ")); //Example of adding another object to the data list (another card)
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error getting weather data", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void createNewsCard() {
//        newsApiClient = NewsApiClient.getInstance();
//        Call<NewsFeed> call = NewsApiClient.getArticles();
//        call.enqueue(new Callback<NewsFeed>() {
//            @Override
//            public void onResponse(Call<NewsFeed> call, Response<NewsFeed> response) {
//                NewsFeed newsFeed = response.body();
//                CardAdapter newsCardAdapter = (CardAdapter) recyclerView.getAdapter();
//                newsCardAdapter.addToDataList(newsFeed);
//            }
//
//            @Override
//            public void onFailure(Call<NewsFeed> call, Throwable t) {
//
//            }
//        });
//    }
}
