package nyc.c4q.rafaelsoto.nowfeed.networks.geolocation;

import nyc.c4q.rafaelsoto.nowfeed.models.geolocation.GeoLocation;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dannylui on 11/8/16.
 */

public class GeoLocationClient {
    private static final String API_URL = "http://ip-api.com/";
    private static GeoLocationClient instance;
    private final GeoLocationApi api;

    private GeoLocationClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(GeoLocationApi.class);
    }

    public static GeoLocationClient getInstance() {
        if (instance == null) {
            instance = new GeoLocationClient();
        }
        return instance;
    }

    public Call<GeoLocation> getLocation() {
        return api.getLocation();
    }
}
