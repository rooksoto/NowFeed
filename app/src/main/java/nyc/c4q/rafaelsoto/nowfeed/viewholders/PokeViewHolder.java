package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.Stat;
import nyc.c4q.rafaelsoto.nowfeed.models.pokeapi.Type;
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
    private TextView pokeType;
    private TextView pokeStat;
    private RelativeLayout pokeContainer;
    private Map<Integer,DetailPokeModel> pokeCachedMap;

    private boolean hasLoaded;

    public PokeViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        pokeTv = (TextView) mView.findViewById(R.id.poke_tv);
        pokeBtn = (Button) mView.findViewById(R.id.poke_btn);
        pokeImage = (ImageView) mView.findViewById(R.id.poke_image);
        pokeType = (TextView) mView.findViewById(R.id.poke_tv_type);
        pokeStat = (TextView) mView.findViewById(R.id.poke_tv_stat);
        pokeContainer = (RelativeLayout) mView.findViewById(R.id.poke_container);
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
            setPokeViews(model);
            hasLoaded = true;
        } else {
            callPokeApi(randomNum + 1);
        }
    }

    private void callPokeApi(final int randomNum) {
        PokeClient client = PokeClient.getInstance();
        Call<DetailPokeModel> call = client.getSpecificPokemon(randomNum);
        call.enqueue(new Callback<DetailPokeModel>() {
            @Override
            public void onResponse(Call<DetailPokeModel> call, Response<DetailPokeModel> response) {
                System.out.println("GOT A RESPONSE FOR POKE IMAGE");
                DetailPokeModel model = response.body();
                setPokeViews(model);
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
                        setPokeViews(model);
                        hasLoaded = true;
                    } else {
                        callPokeApi(randomNum + 1);
                    }
                } else {
                    System.out.println("Pokemon not yet loaded ");
                }
        }
    }

    public void setPokeViews(DetailPokeModel model) {
        //Left column
        String spriteUrl = model.getSprites().getFrontDefault();
        Glide.with(mView.getContext()).load(spriteUrl).into(pokeImage);
        pokeTv.setText(model.getName());

        //Right column
        List<Type> typeList = model.getTypes();
        String typeString = "";
        for (int i = 0; i < typeList.size(); i++) {
            typeString += typeList.get(i).getType().getName() + "\n";
        }
        pokeType.setText(typeString);

        List<Stat> statList = model.getStats();
        String statString = "";
        for (int i = 0; i < statList.size(); i++) {
            statString += statList.get(i).getStat().getName() + ": " + statList.get(i).getBaseStat() + "\n";
        }
        pokeStat.setText(statString);

        setBackgroundColor(typeList);
    }

    private void setBackgroundColor(List<Type> typeList) {
        for (Type type : typeList) {
            String typeName = type.getType().getName();
            switch (typeName) {
                case "grass":
                    pokeContainer.setBackgroundResource(R.color.grassGreen);
                    break;
                case "bug":
                    pokeContainer.setBackgroundResource(R.color.grassGreen);
                    break;
                case "ghost":
                    pokeContainer.setBackgroundResource(R.color.ghostPurple);
                    break;
                case "water":
                    pokeContainer.setBackgroundResource(R.color.waterBlue);
                    break;
                case "ice":
                    pokeContainer.setBackgroundResource(R.color.iceBlue);
                    break;
                case "fire":
                    pokeContainer.setBackgroundResource(R.color.fireRed);
                    break;
                case "ground":
                    pokeContainer.setBackgroundResource(R.color.groundBrown);
                    break;
                case "rock":
                    pokeContainer.setBackgroundResource(R.color.groundBrown);
                    break;
                case "normal":
                    pokeContainer.setBackgroundResource(R.color.normalSkin);
                    break;
                case "fighting":
                    pokeContainer.setBackgroundResource(R.color.fightingSkin);
                    break;
                case "electric":
                    pokeContainer.setBackgroundResource(R.color.electricYellow);
                    break;
                case "psychic":
                    pokeContainer.setBackgroundResource(R.color.psychicPurple);
                    break;
                case "dragon":
                    pokeContainer.setBackgroundResource(R.color.dragonGreen);
                    break;
                default:
                    pokeContainer.setBackgroundColor(0x70000000);
            }
        }
    }


    public int getRandomNum() {
        Random rand = new Random();
        return rand.nextInt(151);
    }


}
