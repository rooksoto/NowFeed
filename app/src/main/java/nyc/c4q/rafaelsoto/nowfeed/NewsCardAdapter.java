package nyc.c4q.rafaelsoto.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.NewsViewHolder;


/**
 * Created by rook on 11/10/16.
 */


public class NewsCardAdapter extends RecyclerView.Adapter {

    private List<Articles> articleList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        viewHolder = new NewsViewHolder(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        NewsViewHolder newsViewHolder = (NewsViewHolder) holder;
        newsViewHolder.bind(articleList.get(position));

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public void addArticles (Articles articles) {
        articleList.add(articles);
        notifyDataSetChanged(); //Added this because Danny is brilliant, and he said so.
                                //Joking... I understand why the notification must take place.
    }
}
