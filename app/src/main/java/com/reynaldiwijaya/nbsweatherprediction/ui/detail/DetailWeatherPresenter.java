package com.reynaldiwijaya.nbsweatherprediction.ui.detail;

import android.util.Log;

import com.reynaldiwijaya.nbsweatherprediction.BuildConfig;
import com.reynaldiwijaya.nbsweatherprediction.model.ResponseWeather;
import com.reynaldiwijaya.nbsweatherprediction.model.WeatherItem;
import com.reynaldiwijaya.nbsweatherprediction.network.ApiClient;
import com.reynaldiwijaya.nbsweatherprediction.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailWeatherPresenter {

    private DetailWeatherContract view;
    private ApiService service = ApiClient.getClient().create(ApiService.class);

    public DetailWeatherPresenter(DetailWeatherContract view) {
        this.view = view;
    }

    public void getWeather(String city) {
        view.showProgress();
        Call<ResponseWeather> call = service.getWeather(city, BuildConfig.API_KEY);
        call.enqueue(new Callback<ResponseWeather>() {
            @Override
            public void onResponse(Call<ResponseWeather> call, Response<ResponseWeather> response) {
                view.hideProgress();
                if (response.body() != null) {
                    double tempInKelvin = response.body().getMain().getTemp();
                    double tempInCelcius = tempInKelvin - 273;

                    String desc = response.body().getWeatherItems().get(0).getDesc();
                    String main = response.body().getWeatherItems().get(0).getMain();

                    view.showData(tempInCelcius, desc, main);

                }
            }

            @Override
            public void onFailure(Call<ResponseWeather> call, Throwable t) {
                view.hideProgress();
                view.showFailure("Network failure");
                Log.e("Error", t.getMessage());
            }
        });
    }
}
