package com.example.raghu_gowda.dag2;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {
    private final PopularMoviesApplication application;

    public ApplicationModule(PopularMoviesApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }
}
