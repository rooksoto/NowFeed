package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.DetailPokeModel;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.PokeModel;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.Result;
import nyc.c4q.rafaelsoto.nowfeed.networks.pokeapi.PokeClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Danny on 11/17/2016.
 */

public class PokeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private List<Result> pokemonList = new ArrayList<>();
    private final View mView;
    private TextView pokeTv;
    private Button pokeBtn;
    private ImageView pokeImage;
    private Map<Integer,DetailPokeModel> pokeCachedMap;

    private boolean hasLoaded;

    public PokeViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        pokeTv = (TextView) mView.findViewById(R.id.poke_tv);
        pokeBtn = (Button) mView.findViewById(R.id.poke_btn);
        pokeImage = (ImageView) mView.findViewById(R.id.poke_image);
        pokeCachedMap = new HashMap<>();
        pokeBtn.setOnClickListener(this);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.poke_card_layout, parent, false);
    }

    public void bind(Object data) {
        hasLoaded = false;
        PokeModel pokeModel = (PokeModel) data;
        pokemonList = pokeModel.getResults();

        int randomNum = getRandomNum();

        if (pokeCachedMap.containsKey(randomNum+1)) {
            DetailPokeModel model = pokeCachedMap.get(randomNum+1);
            String spriteUrl = model.getSprites().getFrontDefault();
            Glide.with(mView.getContext()).load(spriteUrl).into(pokeImage);
            pokeTv.setText(model.getName());
            hasLoaded = true;
        } else {
            setPokeCardContent(randomNum + 1);
        }
    }

    private void setPokeCardContent(final int randomNum) {
        PokeClient client = PokeClient.getInstance();
        Call<DetailPokeModel> call = client.getSpecificPokemon(randomNum);
        call.enqueue(new Callback<DetailPokeModel>() {
            @Override
            public void onResponse(Call<DetailPokeModel> call, Response<DetailPokeModel> response) {
                System.out.println("GOT A RESPONSE FOR POKE IMAGE");
                DetailPokeModel model = response.body();
                System.out.println(model);
                String spriteUrl = model.getSprites().getFrontDefault();
                System.out.println(spriteUrl);
                Glide.with(mView.getContext()).load(spriteUrl).into(pokeImage);
                pokeTv.setText(model.getName());

                pokeCachedMap.put(randomNum, model);

                hasLoaded = true;
            }

            @Override
            public void onFailure(Call<DetailPokeModel> call, Throwable t) {
                System.out.println("Failed to load poke image");
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.poke_btn:
                if (hasLoaded) {
                    hasLoaded = false;
                    int randomNum = getRandomNum();
                    if (pokeCachedMap.containsKey(randomNum+1)) {
                        DetailPokeModel model = pokeCachedMap.get(randomNum+1);
                        String spriteUrl = model.getSprites().getFrontDefault();
                        Glide.with(mView.getContext()).load(spriteUrl).into(pokeImage);
                        pokeTv.setText(model.getName());
                        hasLoaded = true;
                    } else {
                        setPokeCardContent(randomNum + 1);
                    }
                } else {
                    System.out.println("Pokemon not yet loaded ");
                }
        }
    }

    public int getRandomNum() {
        Random rand = new Random();
        return rand.nextInt(151);
    }
}
