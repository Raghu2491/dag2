package com.example.raghu_gowda.dag2;

import android.app.Application;

import com.example.raghu_gowda.dag2.api_dag.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationModuleComponent {

    Application application();
    void inject(PopularMoviesApplication popularMoviesApplication);
}
