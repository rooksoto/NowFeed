package nyc.c4q.rafaelsoto.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Article;

/**
 * Created by dannylui on 11/12/16.
 */
public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private ImageView newsImage;
    private TextView headline;

    private final View mView;

    public ArticleViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;

        newsImage = (ImageView) mView.findViewById(R.id.news_item_image);
        headline = (TextView) mView.findViewById(R.id.news_item_headline);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.news_item_layout, parent, false);
    }

    public void bind(Article article) {
        String title = article.getTitle();
        String description = article.getDescription();
        String imageUrl = article.getUrlToImage();

        Glide.with(mView.getContext()).load(imageUrl).into(newsImage);
        headline.setText(title);


    }


}
