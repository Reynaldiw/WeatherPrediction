package com.reynaldiwijaya.nbsweatherprediction.network;

import com.reynaldiwijaya.nbsweatherprediction.BuildConfig;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//@Module
public class ApiClient {

    private static Retrofit retrofit = null;

//    @Provides
    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build();

        return retrofit;
    }

//    @Provides
//    ApiService provideApiService(Retrofit retrofit) {
//        return retrofit.create(ApiService.class);
//    }

}
