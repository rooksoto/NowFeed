package nyc.c4q.rafaelsoto.nowfeed.networks.darksky;

import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dannylui on 10/31/16.
 */

//Client that will interact with DarkSkyApi
public class DarkSkyClient {
    private static final String API_URL = "https://api.darksky.net/";
    private static final String API_KEY = "651468c7f59636611b67cfe0e5e452f7";

    //Singleton instance of this class - only one instance belongs to this class
    private static DarkSkyClient instance;

    private final DarkSkyApi api;

    public static DarkSkyClient getInstance() {
        if (instance == null) {
            instance = new DarkSkyClient();
        }
        return instance;
    }

    private DarkSkyClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(DarkSkyApi.class);
    }

    public Call<Forecast> getForecast(String latLon) {
        return api.getForecast(API_KEY, latLon);
    }
}
