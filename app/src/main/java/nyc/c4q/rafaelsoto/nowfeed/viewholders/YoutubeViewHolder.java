package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.User;

/**
 * Created by dannylui on 10/31/16.
 */
public class YoutubeViewHolder extends RecyclerView.ViewHolder implements YouTubePlayer.OnInitializedListener, View.OnClickListener {
    private final View mView;
    private Button searchButton;

    private YouTubePlayerFragment youtubePlayerFragment;
    private YouTubePlayer youTubePlayer;


    public YoutubeViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        searchButton = (Button) mView.findViewById(R.id.search_button_view);
        youtubePlayerFragment = new YouTubePlayerFragment();
        youtubePlayerFragment.initialize("AIzaSyDZmVc9fCAqZy4YcoHWvWcB9XzhkV06tNQ", this);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.youtube_card_layout, parent, false);
    }

    public void bind(Object data) {
        User user_name = (User) data;
        String name = user_name.getName();
        ((Activity) itemView.getContext()).getFragmentManager()
                .beginTransaction()
                .replace(R.id.youtube_fragment_view, youtubePlayerFragment)
                .commit();

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
        }
    }
}

