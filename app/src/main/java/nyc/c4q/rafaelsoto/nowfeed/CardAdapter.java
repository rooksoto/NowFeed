package nyc.c4q.rafaelsoto.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;
import nyc.c4q.rafaelsoto.nowfeed.models.youtube.YoutubeItem;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.DefaultViewHolder;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.YoutubeViewHolder;
import nyc.c4q.rafaelsoto.nowfeed.viewholders.WeatherViewHolder;

/**
 * Created by dannylui on 10/31/16.
 */
public class CardAdapter extends RecyclerView.Adapter {
    private List<Object> dataList = new ArrayList<Object>(); //List of objects, anything can be placed in here

    //1. Add a final number to your "card", example: YOUTUBE = 2, and so on...
    private final int WEATHER = 0, YOUTUBE = 1;

    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position) instanceof Forecast) {
            System.out.println("getItemViewType: weather");
            return WEATHER;
        } else if (dataList.get(position) instanceof YoutubeItem) {
            System.out.println("getItemViewType: user");
            return YOUTUBE;
        } //2. getItemViewType() returns constant number depending on the type of object in the dataList
          //   then feeds it to onCreateViewHolder() to inflate a viewholder depending on that constant number
          //   - essentially allows different view holders for the same adapter (in our case, different cards)
          //   Add another else if for your card,
          //   example: else if (dataList.(position) instanceof <name_of_your_POJO>)
          //            return <your_card_constant_in_the_field>
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch(viewType) {
            case WEATHER:
                System.out.println("Inflating viewHolder: weather");
                viewHolder = new WeatherViewHolder(parent);
                break;
            case YOUTUBE:
                System.out.println("Inflating viewHolder: user");
                viewHolder = new YoutubeViewHolder(parent);
                break;
            //3. Inflating your personalized view holder...
            //   Add a case for <your_card_constant>
            //   set viewHolder = new custom <your_view_holder_class> that you'll make

            default:
                System.out.println("Inflating viewHolder: default");
                viewHolder = new DefaultViewHolder(parent);
                break;
        }
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch(holder.getItemViewType()){
            case WEATHER:
                WeatherViewHolder weatherViewHolder = (WeatherViewHolder) holder;
                weatherViewHolder.bind(dataList.get(position));
                break;
            case YOUTUBE:
                YoutubeViewHolder youtubeViewHolder = (YoutubeViewHolder) holder;
                youtubeViewHolder.bind(dataList.get(position));
                break;
            //4. Data that is in dataList.get(position) is the data you sent from MainActivity
            //   You'll then send this data to your view holder class here
            //   Add a case for <your_card_constant>
            //   call the bind() method in your view holder class that will stylize your data with the your card layout
        }


    }

    public void addToDataList(Object data) {
        dataList.add(data);
        notifyDataSetChanged(); //important method that lets the adapter know that cards has been changed (added, removed, updated)
                                //will cause getItemViewType(), onCreateViewHolder, and onBindViewHolder() to run again
                                //to update those changes in the recycler view
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
