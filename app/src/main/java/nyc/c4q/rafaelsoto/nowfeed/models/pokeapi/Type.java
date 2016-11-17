package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class Type {

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("type")
    @Expose
    private Type_ type;

    public Integer getSlot() {
        return slot;
    }

    public Type_ getType() {
        return type;
    }
}