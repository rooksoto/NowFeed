package nyc.c4q.rafaelsoto.nowfeed.networks.newsapi;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rook on 11/4/16.
 */

public interface NewsApi {

    @GET("v1/articles")
    Call<NewsFeed> getArticles(
            @Query("source") String source,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

}
