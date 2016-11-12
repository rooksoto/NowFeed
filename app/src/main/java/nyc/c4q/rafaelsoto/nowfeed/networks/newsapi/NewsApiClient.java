package nyc.c4q.rafaelsoto.nowfeed.networks.newsapi;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rook on 11/4/16.
 */

public class NewsApiClient {

    private static final String API_URL = "https://newsapi.org/";

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
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(NewsApi.class);
    }

    public Call<Articles> getArticles() {
        return api.getArticles();
    }
}
