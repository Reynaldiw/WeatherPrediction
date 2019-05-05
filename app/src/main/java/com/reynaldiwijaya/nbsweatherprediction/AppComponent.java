package com.reynaldiwijaya.nbsweatherprediction;

import com.reynaldiwijaya.nbsweatherprediction.network.ApiClient;
import com.reynaldiwijaya.nbsweatherprediction.ui.detail.DetailWeatherActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {
        ApiClient.class
})
@Singleton
public interface AppComponent {
    void inject(DetailWeatherActivity detailWeatherActivity);
}
