package nyc.c4q.rafaelsoto.nowfeed.networks.geolocation;

import nyc.c4q.rafaelsoto.nowfeed.models.geolocation.GeoLocation;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dannylui on 11/8/16.
 */

public interface GeoLocationApi {
    @GET ("json")
    Call<GeoLocation> getLocation();
}
