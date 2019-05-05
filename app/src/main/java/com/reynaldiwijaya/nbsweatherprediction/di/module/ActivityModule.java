package com.reynaldiwijaya.nbsweatherprediction.di.module;

import android.app.Activity;

import com.reynaldiwijaya.nbsweatherprediction.ui.detail.DetailWeatherContract;
import com.reynaldiwijaya.nbsweatherprediction.ui.detail.DetailWeatherPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;
    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    public Activity provideActivity(){
        return activity;
    }

    @Provides
    public DetailWeatherPresenter providePresenter() {
        return new DetailWeatherPresenter((DetailWeatherContract) activity);
    }
}
