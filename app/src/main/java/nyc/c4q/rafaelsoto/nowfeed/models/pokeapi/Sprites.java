package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Danny on 11/17/2016.
 */

public class Sprites {

    @SerializedName("back_female")
    @Expose
    private Object backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private Object backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private Object frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private Object frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;

    public Object getBackFemale() {
        return backFemale;
    }

    public Object getBackShinyFemale() {
        return backShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public Object getFrontFemale() {
        return frontFemale;
    }

    public Object getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }
}
