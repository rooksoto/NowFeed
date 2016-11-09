package nyc.c4q.rafaelsoto.nowfeed.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;

import nyc.c4q.rafaelsoto.nowfeed.R;
import nyc.c4q.rafaelsoto.nowfeed.models.darksky.Forecast;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by dannylui on 10/31/16.
 */
public class WeatherViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private TextView detailView;
    private ImageView currentIconView;
    private TextView currentTempView;

    private TextView dayOneView;
    private TextView dayTwoView;
    private TextView dayThreeView;
    private TextView dayFourView;
    private TextView dayFiveView;

    private ImageView dayOneIconView;
    private ImageView dayTwoIconView;
    private ImageView dayThreeIconView;
    private ImageView dayFourIconView;
    private ImageView dayFiveIconView;

    private TextView dayOneHiView;
    private TextView dayTwoHiView;
    private TextView dayThreeHiView;
    private TextView dayFourHiView;
    private TextView dayFiveHiView;

    private TextView dayOneLoView;
    private TextView dayTwoLoView;
    private TextView dayThreeLoView;
    private TextView dayFourLoView;
    private TextView dayFiveLoView;


    public WeatherViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        initViews();

    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.weather_card_layout, parent, false);
    }

    public void bind(Object data) {
        Forecast forecastData = (Forecast) data;

        //Detail
        String summary = forecastData.getCurrently().getSummary();
        String windSpeed = String.valueOf(Math.round(forecastData.getCurrently().getWindSpeed()));
        String precipitation = String.valueOf((int)(forecastData.getCurrently().getPrecipProbability() * 100));
        detailView.setText(summary + "  Wind " + windSpeed + "m/h  Precip  " + precipitation + "%");

        //Current temp icon
        String currentIcon = forecastData.getCurrently().getIcon();
        handleIcons(currentIcon, currentIconView);


        //Current temp
        String currentTemp = Math.round(forecastData.getCurrently().getTemperature()) + "°";
        currentTempView.setText(currentTemp);

        //Days of the week
        String dayOne = unixTsToDay(forecastData.getDaily().getData().get(1).getTime());
        String dayTwo = unixTsToDay(forecastData.getDaily().getData().get(2).getTime());
        String dayThree = unixTsToDay(forecastData.getDaily().getData().get(3).getTime());
        String dayFour = unixTsToDay(forecastData.getDaily().getData().get(4).getTime());
        String dayFive = unixTsToDay(forecastData.getDaily().getData().get(5).getTime());

        dayOneView.setText(dayOne);
        dayTwoView.setText(dayTwo);
        dayThreeView.setText(dayThree);
        dayFourView.setText(dayFour);
        dayFiveView.setText(dayFive);

        //Icons for each day
        String dayOneIcon = forecastData.getDaily().getData().get(1).getIcon();
        String dayTwoIcon = forecastData.getDaily().getData().get(2).getIcon();
        String dayThreeIcon = forecastData.getDaily().getData().get(3).getIcon();
        String dayFourIcon = forecastData.getDaily().getData().get(4).getIcon();
        String dayFiveIcon = forecastData.getDaily().getData().get(5).getIcon();

        handleIcons(dayOneIcon, dayOneIconView);
        handleIcons(dayTwoIcon, dayTwoIconView);
        handleIcons(dayThreeIcon, dayThreeIconView);
        handleIcons(dayFourIcon, dayFourIconView);
        handleIcons(dayFiveIcon, dayFiveIconView);

        //Highs for each day
        String dayOneHi = Math.round(forecastData.getDaily().getData().get(1).getTemperatureMax()) + "°";
        String dayTwoHi = Math.round(forecastData.getDaily().getData().get(2).getTemperatureMax()) + "°";
        String dayThreeHi = Math.round(forecastData.getDaily().getData().get(3).getTemperatureMax()) + "°";
        String dayFourHi = Math.round(forecastData.getDaily().getData().get(4).getTemperatureMax()) + "°";
        String dayFiveHi = Math.round(forecastData.getDaily().getData().get(5).getTemperatureMax()) + "°";

        dayOneHiView.setText(dayOneHi);
        dayTwoHiView.setText(dayTwoHi);
        dayThreeHiView.setText(dayThreeHi);
        dayFourHiView.setText(dayFourHi);
        dayFiveHiView.setText(dayFiveHi);

        //Lows for each day
        String dayOneLo = Math.round(forecastData.getDaily().getData().get(1).getTemperatureMin()) + "°";
        String dayTwoLo = Math.round(forecastData.getDaily().getData().get(2).getTemperatureMin()) + "°";
        String dayThreeLo = Math.round(forecastData.getDaily().getData().get(3).getTemperatureMin()) + "°";
        String dayFourLo = Math.round(forecastData.getDaily().getData().get(4).getTemperatureMin()) + "°";
        String dayFiveLo = Math.round(forecastData.getDaily().getData().get(5).getTemperatureMin()) + "°";

        dayOneLoView.setText(dayOneLo);
        dayTwoLoView.setText(dayTwoLo);
        dayThreeLoView.setText(dayThreeLo);
        dayFourLoView.setText(dayFourLo);
        dayFiveLoView.setText(dayFiveLo);
    }

    public String unixTsToDay(int unixTs) {
        java.util.Date date = new java.util.Date((long)unixTs*1000);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("E");
        return dateFormatter.format(date);

    }

    public void initViews() {
        detailView = (TextView) mView.findViewById(R.id.detail_view);
        currentIconView = (ImageView) mView.findViewById(R.id.current_icon_view);
        currentTempView = (TextView) mView.findViewById(R.id.current_temp_view);

        dayOneView = (TextView) mView.findViewById(R.id.day_one_view);
        dayTwoView = (TextView) mView.findViewById(R.id.day_two_view);
        dayThreeView = (TextView) mView.findViewById(R.id.day_three_view);
        dayFourView = (TextView) mView.findViewById(R.id.day_four_view);
        dayFiveView = (TextView) mView.findViewById(R.id.day_five_view);

        dayOneIconView = (ImageView) mView.findViewById(R.id.day_one_icon_view);
        dayTwoIconView = (ImageView) mView.findViewById(R.id.day_two_icon_view);
        dayThreeIconView = (ImageView) mView.findViewById(R.id.day_three_icon_view);
        dayFourIconView = (ImageView) mView.findViewById(R.id.day_four_icon_view);
        dayFiveIconView = (ImageView) mView.findViewById(R.id.day_five_icon_view);

        dayOneHiView = (TextView) mView.findViewById(R.id.day_one_hi_view);
        dayTwoHiView = (TextView) mView.findViewById(R.id.day_two_hi_view);
        dayThreeHiView = (TextView) mView.findViewById(R.id.day_three_hi_view);
        dayFourHiView = (TextView) mView.findViewById(R.id.day_four_hi_view);
        dayFiveHiView = (TextView) mView.findViewById(R.id.day_five_hi_view);

        dayOneLoView = (TextView) mView.findViewById(R.id.day_one_lo_view);
        dayTwoLoView = (TextView) mView.findViewById(R.id.day_two_lo_view);
        dayThreeLoView = (TextView) mView.findViewById(R.id.day_three_lo_view);
        dayFourLoView = (TextView) mView.findViewById(R.id.day_four_lo_view);
        dayFiveLoView = (TextView) mView.findViewById(R.id.day_five_lo_view);
    }

    public void handleIcons(String iconText, ImageView iconView) {
        switch(iconText) {
            case "clear-day":
                Glide.with(mView.getContext()).load(R.drawable.skycon_clear_day).into(iconView);
                break;
            case "clear-night":
                Glide.with(mView.getContext()).load(R.drawable.skycon_clear_night).into(iconView);
                break;
            case "rain":
                Glide.with(mView.getContext()).load(R.drawable.skycon_rain).into(iconView);
                break;
            case "snow":
                Glide.with(mView.getContext()).load(R.drawable.skycon_snow).into(iconView);
                break;
            case "sleet":
                Glide.with(mView.getContext()).load(R.drawable.skycon_sleet).into(iconView);
                break;
            case "wind":
                Glide.with(mView.getContext()).load(R.drawable.skycon_wind).into(iconView);
                break;
            case "fog":
                Glide.with(mView.getContext()).load(R.drawable.skycon_fog).into(iconView);
                break;
            case "cloudy":
                Glide.with(mView.getContext()).load(R.drawable.skycon_cloudy).into(iconView);
                break;
            case "partly-cloudy-day":
                Glide.with(mView.getContext()).load(R.drawable.skycon_partly_cloudy_day).into(iconView);
                break;
            case "partly-cloudy-night":
                Glide.with(mView.getContext()).load(R.drawable.skycon_party_cloudy_night).into(iconView);
                break;
            default:
                Log.d(TAG, "handleIcons: " + iconText + iconView.toString());
        }
    }
}
