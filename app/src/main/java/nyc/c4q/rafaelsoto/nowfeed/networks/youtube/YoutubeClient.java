package nyc.c4q.rafaelsoto.nowfeed.networks.youtube;

import nyc.c4q.rafaelsoto.nowfeed.models.youtube.YoutubeModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Danny on 11/11/2016.
 */

public class YoutubeClient {
    private static final String API_KEY = "AIzaSyDZmVc9fCAqZy4YcoHWvWcB9XzhkV06tNQ";
    private static YoutubeClient instance;
    private final YoutubeApi api;

    private YoutubeClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(YoutubeApi.class);
    }

    public static YoutubeClient getInstance() {
        if (instance == null) {
            instance = new YoutubeClient();
        }
        return instance;
    }

    public Call<YoutubeModel> getVideos(String searchQuery) {
        return api.getVideos(API_KEY, "snippet", "video", searchQuery);
    }
}
