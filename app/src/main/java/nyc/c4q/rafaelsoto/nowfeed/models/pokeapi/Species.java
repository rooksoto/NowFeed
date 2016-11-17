package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class Species {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}