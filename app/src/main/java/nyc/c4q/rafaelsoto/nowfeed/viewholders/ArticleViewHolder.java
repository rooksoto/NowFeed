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
import nyc.c4q.rafaelsoto.nowfeed.models.newsapi.Article;

/**
 * Created by dannylui on 11/12/16.
 */

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    private ImageView articleImage;
    private TextView articleHeadline;
    private TextView articleAuthor;
    private Intent intent;

    private final View mView;
    private View.OnClickListener openInBrowser;

    public ArticleViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;

        articleImage = (ImageView) mView.findViewById(R.id.news_item_image);
        articleHeadline = (TextView) mView.findViewById(R.id.news_item_headline);
        articleAuthor = (TextView) mView.findViewById(R.id.news_item_author);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.news_item_layout, parent, false);
    }

    public void bind(Article article) {

        String title = article.getTitle();
        String author = "By: " + article.getAuthor();

        String imageUrl = article.getUrlToImage();

        Glide.with(mView.getContext()).load(imageUrl).into(articleImage);
        articleHeadline.setText(title);
        articleAuthor.setText(author);

        articleHeadline.setOnClickListener(openInBrowser);
        articleImage.setOnClickListener(openInBrowser);

        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.getUrl()));



        openInBrowser = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.getContext().startActivity(intent);
            }
        };
    }
}
