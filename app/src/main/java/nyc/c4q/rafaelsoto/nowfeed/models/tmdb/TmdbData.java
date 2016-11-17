
package nyc.c4q.rafaelsoto.nowfeed.models.tmdb;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TmdbData {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("results")
    @Expose
    public List<Result> results = new ArrayList<>();
    @SerializedName("dates")
    @Expose
    public Dates dates;
    @SerializedName("total_pages")
    @Expose
    public Integer totalPages;
    @SerializedName("total_results")
    @Expose
    public Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public List<Result> getResults() {
        return results;
    }

    public Dates getDates() {
        return dates;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }
}
