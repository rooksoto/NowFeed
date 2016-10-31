package nyc.c4q.rafaelsoto.nowfeed.networks.darksky;

import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dannylui on 10/31/16.
 */

public interface DarkSkyApi {
    @GET("forecast/{key}/{latitude_longitude}")
    Call<Forecast> getForecast(
            @Path("key") String apiKey,
            @Path("latitude_longitude") String latLon);
}
