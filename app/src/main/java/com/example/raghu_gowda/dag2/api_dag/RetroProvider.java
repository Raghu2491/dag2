package com.example.raghu_gowda.dag2.api_dag;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetroProvider {


    @Provides @NewScope
    public MoviesApi provideMoviesApi(Retrofit retrofit) {
        return retrofit.create(MoviesApi.class);
    }
}
