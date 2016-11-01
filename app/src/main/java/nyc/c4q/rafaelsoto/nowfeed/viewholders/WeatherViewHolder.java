package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;

/**
 * Created by dannylui on 10/31/16.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private TextView currentTempView;
    public WeatherViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        currentTempView = (TextView) mView.findViewById(R.id.current_temp_view);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.weather_card_layout, parent, false);
    }

    public void bind(Object data) {
        Forecast forecastData = (Forecast) data;
        String currentTemp = String.valueOf(forecastData.getCurrently().getTemperature());
        currentTempView.setText(currentTemp);
    }
}
