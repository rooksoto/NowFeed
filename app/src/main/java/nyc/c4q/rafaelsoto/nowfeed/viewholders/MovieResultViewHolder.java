package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.Result;

/**
 * Created by rook on 11/17/16.
 */

public class MovieResultViewHolder extends RecyclerView.ViewHolder {
    private ImageView moviePoster;
    private TextView movieTitle;
    private TextView movieBlurb;
    private Intent intent;

    private final View mView;
    private View.OnClickListener openInBrowser;

    public MovieResultViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;

        moviePoster = (ImageView) mView.findViewById(R.id.movie_poster_image);
        movieTitle = (TextView) mView.findViewById(R.id.movie_title);
        movieBlurb = (TextView) mView.findViewById(R.id.movie_blurb);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.movie_item_layout, parent, false);
    }

    public void bind(Result result) {

        String title = result.getTitle();
        String blurb = result.getOverview();

        String imageUrl = "http://image.tmdb.org/t/p/w185//" + result.getPosterPath();

        Glide.with(mView.getContext()).load(imageUrl).into(moviePoster);
        movieTitle.setText(title);
        movieBlurb.setText(blurb);

        movieTitle.setOnClickListener(openInBrowser);
        moviePoster.setOnClickListener(openInBrowser);

//        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://api.themoviedb.org/3/movie/" + result.getId() + "/videos?api_key=3eea98d386bf057ace88e9606014c8f0"));
//
//
//
//        openInBrowser = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mView.getContext().startActivity(intent);
//            }
//        };
    }
}