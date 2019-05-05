package com.reynaldiwijaya.nbsweatherprediction.model;

import com.google.gson.annotations.SerializedName;

public class WeatherItem {

    @SerializedName("description")
    private String desc;

    @SerializedName("main")
    private String main;

    public String getDesc() {
        return desc;
    }

    public String getMain() {
        return main;
    }
}
