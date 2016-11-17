package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

/**
 * Created by Danny on 11/17/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Move {

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = new ArrayList<VersionGroupDetail>();
    @SerializedName("move")
    @Expose
    private Move_ move;

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public Move_ getMove() {
        return move;
    }
}