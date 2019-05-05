package com.reynaldiwijaya.nbsweatherprediction.ui.detail;

public interface DetailWeatherContract {
    void showProgress();
    void hideProgress();
    void showData(double temp, String desc, String main);
    void showFailure(String message);
}
