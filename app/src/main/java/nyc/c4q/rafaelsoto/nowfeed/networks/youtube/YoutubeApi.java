package nyc.c4q.rafaelsoto.nowfeed.networks.youtube;

import nyc.c4q.rafaelsoto.nowfeed.models.youtube.YoutubeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Danny on 11/11/2016.
 */

public interface YoutubeApi {
    @GET("youtube/v3/search")
    Call<YoutubeModel> getVideos(
            @Query("key") String key,
            @Query("part") String part,
            @Query("type") String type,
            @Query("q") String searchQuery
    );
}
