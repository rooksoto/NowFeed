package nyc.c4q.rafaelsoto.nowfeed.models.pokeapi;

/**
 * Created by Danny on 11/17/2016.
 */

import java.util.ArrayList;
import java.util.List;

public class PokeModel {

    private Integer count;
    private Object previous;
    private List<Result> results = new ArrayList<Result>();
    private String next;

    public Integer getCount() {
        return count;
    }

    public Object getPrevious() {
        return previous;
    }

    public List<Result> getResults() {
        return results;
    }

    public String getNext() {
        return next;
    }
}
