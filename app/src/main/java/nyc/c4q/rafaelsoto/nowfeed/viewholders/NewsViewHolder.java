package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Articles;

/**
 * Created by rook on 11/10/16.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder {

    private ImageView newsImage;
    private TextView headline;
    private URL newsLink;

    private final View mView;

    public NewsViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.news_card_layout_old, parent, false);
    }

    public void bind(Object data) {

        Articles articles = (Articles) data;
        articles

        newsImage = (ImageView) mView.findViewById(R.id.news_item_image);
        headline = (TextView) mView.findViewById(R.id.news_item_headline);
//        newsLink = (URL);

//        newsImage.setImageResource(Integer.parseInt(articles.getUrlToImage()));
//        headline.setText(articles.getTitle());

    }
}

