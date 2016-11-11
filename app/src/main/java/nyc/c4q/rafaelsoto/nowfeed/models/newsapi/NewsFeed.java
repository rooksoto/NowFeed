package nyc.c4q.rafaelsoto.nowfeed.models.newsapi;

import retrofit2.Call;

/**
 * Created by rook on 11/4/16.
 */

public class NewsFeed
{
    private static Articles[] articles;

    private String sortBy;

    private String source;

    private String status;

//    public Articles[] getArticles ()
//    {
//        return articles;
//    }

    public String getSortBy ()
    {
        return sortBy;
    }

    public String getSource ()
    {
        return source;
    }

    public String getStatus ()
    {
        return status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [articles = "+articles+", sortBy = "+sortBy+", source = "+source+", status = "+status+"]";
    }
}