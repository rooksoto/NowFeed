package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class Ability {

    @SerializedName("slot")
    @Expose
    private Integer slot;
    @SerializedName("is_hidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("ability")
    @Expose
    private Ability_ ability;


    public Integer getSlot() {
        return slot;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public Ability_ getAbility() {
        return ability;
    }
}