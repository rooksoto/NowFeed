package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.youtube.YoutubeModel;
import nyc.c4q.rafaelsoto.nowfeed.networks.youtube.YoutubeClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dannylui on 10/31/16.
 */
public class YoutubeViewHolder extends RecyclerView.ViewHolder implements YouTubePlayer.OnInitializedListener, View.OnClickListener {
    private static final String API_KEY = "AIzaSyDZmVc9fCAqZy4YcoHWvWcB9XzhkV06tNQ";
    private YouTubePlayerFragment youtubePlayerFragment;
    private YouTubePlayer youTubePlayer;
    private YoutubeClient youtubeClient;

    private final View mView;
    private Button searchButton;
    private EditText searchText;


    public YoutubeViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        searchButton = (Button) mView.findViewById(R.id.search_button_view);
        searchText = (EditText) mView.findViewById(R.id.enter_search_text_view);

        youtubePlayerFragment = new YouTubePlayerFragment();
        youtubePlayerFragment.initialize(API_KEY, this);

        youtubeClient = YoutubeClient.getInstance();
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.youtube_card_layout, parent, false);
    }

    public void bind(Object data) { //has no data
        ((Activity) itemView.getContext()).getFragmentManager()
                .beginTransaction()
                .replace(R.id.youtube_fragment_view, youtubePlayerFragment)
                .commit();

        searchButton.setOnClickListener(this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        if(!wasRestored){
            this.youTubePlayer = youTubePlayer;
            youTubePlayer.loadVideo("JoQ4GidQP-k");
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog((Activity)mView.getContext(),1).show();
        } else {
            Toast.makeText(mView.getContext(),
                    "YouTubePlayer.onInitializationFailure(): " + youTubeInitializationResult.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_button_view:
                String searchQuery = searchText.getText().toString();
                searchAndPlay(searchQuery);

                //hides the keyboard afterwards touching search
                InputMethodManager inputManager = (InputMethodManager)
                        mView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(((Activity)mView.getContext()).getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                //searchText.onEditorAction(EditorInfo.IME_ACTION_DONE);
        }
    }

    private void searchAndPlay(String searchQuery) {
        Call<YoutubeModel> call = youtubeClient.getVideos(searchQuery);
        call.enqueue(new Callback<YoutubeModel>() {
            @Override
            public void onResponse(Call<YoutubeModel> call, Response<YoutubeModel> response) {
                YoutubeModel youtubeModel = response.body();
                if (youtubeModel.getItems().size() == 0) {
                    Toast.makeText(mView.getContext(), "No search results", Toast.LENGTH_SHORT).show();
                } else {
                    String vidId = youtubeModel.getItems().get(0).getId().getVideoId();
                    if (youTubePlayer != null) {
                        try {
                            youTubePlayer.loadVideo(vidId);
                        } catch (IllegalStateException e) {
                            Toast.makeText(mView.getContext(), "ytReleased", Toast.LENGTH_SHORT).show();
                        }

                    }

                }
            }

            @Override
            public void onFailure(Call<YoutubeModel> call, Throwable t) {
                Toast.makeText(mView.getContext(), "Failed to connect to youtube", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

