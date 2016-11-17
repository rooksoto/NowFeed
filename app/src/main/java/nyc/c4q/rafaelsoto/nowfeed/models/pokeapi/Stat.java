package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class Stat {

    @SerializedName("stat")
    @Expose
    private Stat_ stat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;

    public Stat_ getStat() {
        return stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public Integer getBaseStat() {
        return baseStat;
    }
}