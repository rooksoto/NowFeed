package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class GameIndex {

    @SerializedName("version")
    @Expose
    private Version version;
    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;

    public Version getVersion() {
        return version;
    }

    public Integer getGameIndex() {
        return gameIndex;
    }
}
