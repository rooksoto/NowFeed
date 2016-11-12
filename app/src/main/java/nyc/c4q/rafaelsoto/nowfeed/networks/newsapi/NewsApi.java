package nyc.c4q.rafaelsoto.nowfeed.networks.newsapi;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rook on 11/4/16.
 */

public interface NewsApi {

    @GET("v1/articles?source=the-next-web&sortBy=latest&apiKey=440d6e9538a94418811caba3b46e2761")
    Call<Articles> getArticles();

}
