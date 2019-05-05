package com.reynaldiwijaya.nbsweatherprediction.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseWeather {

    @SerializedName("weather")
    private List<WeatherItem> weatherItems;

    @SerializedName("main")
    private Main main;

    public List<WeatherItem> getWeatherItems() {
        return weatherItems;
    }

    public Main getMain() {
        return main;
    }
}
