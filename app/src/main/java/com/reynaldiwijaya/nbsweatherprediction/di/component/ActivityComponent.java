package com.reynaldiwijaya.nbsweatherprediction.di.component;

import com.reynaldiwijaya.nbsweatherprediction.di.module.ActivityModule;
import com.reynaldiwijaya.nbsweatherprediction.ui.detail.DetailWeatherActivity;

import dagger.Component;

@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(DetailWeatherActivity detailWeatherActivity);
}
