package com.example.raghu_gowda.dag2.api_dag;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.*;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public final class ApiModule {
    public static final String MOVIE_DB_API_URL = "https://api.meetup.com";
    @Provides
    @CustomScope
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @CustomScope
    GsonConverterFactory provideGsonConverterFactory(){
        return GsonConverterFactory.create();
    }



    @Provides
    @CustomScope
    Retrofit provideRetrofit(RxJavaCallAdapterFactory rxJavaCallAdapterFactory,GsonConverterFactory gsonConverterFactory,
                            OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(MOVIE_DB_API_URL)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .addConverterFactory(gsonConverterFactory)
                .client(client)
                .build();

    }




}
