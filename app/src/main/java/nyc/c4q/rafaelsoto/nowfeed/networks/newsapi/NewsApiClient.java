package nyc.c4q.rafaelsoto.nowfeed.networks.newsapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rook on 11/4/16.
 */

public class NewsApiClient {

    private static final String BASE_URL = "https://newsapi.org/";

    private static NewsApiClient instance;
    private final NewsApi api;

    public static NewsApiClient getInstance() {
        if (instance == null) {
            instance = new NewsApiClient();
        }
        return instance;
    }

    private NewsApiClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(NewsApi.class);
    }

     public Call<Articles> getArticles() {
        return api.getArticles();
    }


}
