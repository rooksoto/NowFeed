package nyc.c4q.rafaelsoto.nowfeed.networks.tmdb;

import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.TmdbData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rook on 11/16/16.
 */

public class TmdbApiClient {

    private static final String API_URL = "https://api.themoviedb.org/";

    private static TmdbApiClient instance;
    private final TmdbApi api;

    public static TmdbApiClient getInstance() {
        if (instance == null) {
            instance = new TmdbApiClient();
        }
        return instance;
    }

    private TmdbApiClient () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(TmdbApi.class);
    }

    public Call<TmdbData> getResults() {
        return api.getResults();
    }

}
