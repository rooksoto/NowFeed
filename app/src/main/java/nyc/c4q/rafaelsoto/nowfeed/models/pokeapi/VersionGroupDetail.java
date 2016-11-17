package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class VersionGroupDetail {

    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }
}
