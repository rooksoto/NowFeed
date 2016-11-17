package nyc.c4q.rafaelsoto.nowfeed.networks.pokeapi;

import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.DetailPokeModel;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.PokeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Danny on 11/17/2016.
 */

public interface PokeApi {
    @GET("pokemon")
    Call<PokeModel> getPokemons(
            @Query("limit") String limit
    );

    @GET("pokemon/{id}")
    Call<DetailPokeModel> getSpecificPokemon(
            @Path("id") int pokemonId
    );

}
