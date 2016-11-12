package nyc.c4q.rafaelsoto.nowfeed.models.newsapi;

/**
 * Created by dannylui on 11/12/16.
 */

import java.util.ArrayList;
import java.util.List;

public class NewsFeed {

    public String status;
    public String source;
    public String sortBy;
    public List<Article> articles = new ArrayList<Article>();

    public String getStatus() {
        return status;
    }

    public String getSource() {
        return source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }
}