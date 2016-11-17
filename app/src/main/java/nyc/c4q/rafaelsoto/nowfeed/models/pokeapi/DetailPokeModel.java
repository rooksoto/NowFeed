package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

/**
 * Created by Danny on 11/17/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DetailPokeModel {

    @SerializedName("forms")
    @Expose
    private List<Form> forms = new ArrayList<Form>();
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = new ArrayList<Ability>();
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = new ArrayList<Stat>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private Integer weight;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = new ArrayList<Move>();
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("held_items")
    @Expose
    private List<Object> heldItems = new ArrayList<Object>();
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = new ArrayList<GameIndex>();
    @SerializedName("base_experience")
    @Expose
    private Integer baseExperience;
    @SerializedName("types")
    @Expose
    private List<Type> types = new ArrayList<Type>();

    public List<Form> getForms() {
        return forms;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public String getName() {
        return name;
    }

    public Integer getWeight() {
        return weight;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public List<Object> getHeldItems() {
        return heldItems;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public Integer getHeight() {
        return height;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public Species getSpecies() {
        return species;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrder() {
        return order;
    }

    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public List<Type> getTypes() {
        return types;
    }

    public String toString() {
        return "Name: " + name + ", Sprite: " + sprites.getFrontDefault();
    }
}
