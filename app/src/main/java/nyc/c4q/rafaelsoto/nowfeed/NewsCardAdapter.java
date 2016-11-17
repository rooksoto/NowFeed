package nyc.c4q.rafaelsoto.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Article;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.ArticleViewHolder;


/**
 * Created by rook on 11/10/16.
 */


public class NewsCardAdapter extends RecyclerView.Adapter {

    private List<Article> articlesList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArticleViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        articleViewHolder.bind(articlesList.get(position));


    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    public void setArticlesList(List<Article> articlesList) {
        this.articlesList = articlesList;
        notifyDataSetChanged(); //Added this because Danny is brilliant, and he said so.
                                //Joking... I understand why the notification must take place.
    }
}
