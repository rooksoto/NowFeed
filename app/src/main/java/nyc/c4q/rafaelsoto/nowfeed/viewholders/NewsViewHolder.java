package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.NewsCardAdapter;
import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Article;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.NewsFeed;

/**
 * Created by rook on 11/10/16.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    private ImageView newsImage;
    private TextView headline;
    private URL newsLink;

    private final View mView;
    private RecyclerView recyclerView;

    public NewsViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        //recyclerview
        recyclerView = (RecyclerView) mView.findViewById(R.id.news_item_holder);
        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new NewsCardAdapter());
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.news_card_layout, parent, false);
    }

    public void bind(Object data) {

        NewsFeed newsFeed = (NewsFeed) data;
        List<Article> articlesList = newsFeed.getArticles();
        NewsCardAdapter adapter = (NewsCardAdapter) recyclerView.getAdapter();

        adapter.setArticlesList(articlesList);



    }
}

