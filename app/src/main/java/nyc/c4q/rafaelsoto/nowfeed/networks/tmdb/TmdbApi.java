package nyc.c4q.rafaelsoto.nowfeed.networks.tmdb;

import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.TmdbData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rook on 11/16/16.
 */

public interface TmdbApi {

    @GET("3/movie/now_playing?api_key=3eea98d386bf057ace88e9606014c8f0&language=en-US")
    Call<TmdbData> getResults();
}
