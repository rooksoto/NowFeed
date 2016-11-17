package nyc.c4q.rafaelsoto.nowfeed.networks.pokeapi;

import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.DetailPokeModel;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.PokeModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Danny on 11/17/2016.
 */

public class PokeClient {
    private static final String API_URL = "http://pokeapi.co/api/v2/";

    //Singleton instance of this class - only one instance belongs to this class
    private static PokeClient instance;

    private final PokeApi api;

    public static PokeClient getInstance() {
        if (instance == null) {
            instance = new PokeClient();
        }
        return instance;
    }

    private PokeClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(PokeApi.class);
    }

    public Call<PokeModel> getPokemons(String limit) {
        return api.getPokemons(limit);
    }

    public Call<DetailPokeModel> getSpecificPokemon(int pokemonId) {
        return api.getSpecificPokemon(pokemonId);
    }
}
