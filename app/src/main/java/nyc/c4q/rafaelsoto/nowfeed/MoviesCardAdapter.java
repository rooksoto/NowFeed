package nyc.c4q.rafaelsoto.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.models.tmdb.Result;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.MovieResultViewHolder;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.MoviesViewHolder;

/**
 * Created by rook on 11/17/16.
 */
public class MoviesCardAdapter extends RecyclerView.Adapter {

    private List<Result> movieList = new ArrayList<>();


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieResultViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MovieResultViewHolder movieResultViewHolder= (MovieResultViewHolder) holder;
        movieResultViewHolder.bind(movieList.get(position));

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setMovieList(List<Result> movieList) {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}
