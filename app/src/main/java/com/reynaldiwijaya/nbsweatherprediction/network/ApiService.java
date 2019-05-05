package com.reynaldiwijaya.nbsweatherprediction.network;

import com.reynaldiwijaya.nbsweatherprediction.model.ResponseWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("data/2.5/weather")
    Call<ResponseWeather> getWeather(
            @Query("q") String city,
            @Query("appid") String apiKey);
}
