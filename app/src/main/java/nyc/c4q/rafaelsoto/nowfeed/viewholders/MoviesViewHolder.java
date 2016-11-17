package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.MoviesCardAdapter;
import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.Result;
import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.TmdbData;

/**
 * Created by rook on 11/17/16.
 */

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    private final View mView;
    private RecyclerView recyclerView;

    public MoviesViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;

        recyclerView = (RecyclerView) mView.findViewById(R.id.movie_item_holder);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new MoviesCardAdapter());
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.movie_card_layout, parent, false);
    }

    public void bind(Object data) {
        TmdbData tmdbData = (TmdbData) data;
        List<Result> movieList = tmdbData.getResults();
        MoviesCardAdapter adapter = (MoviesCardAdapter) recyclerView.getAdapter();

        adapter.setMovieList(movieList);
    }
}
