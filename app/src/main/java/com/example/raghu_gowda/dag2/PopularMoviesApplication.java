package com.example.raghu_gowda.dag2;


import android.app.Application;
import android.content.Context;

import com.example.raghu_gowda.dag2.api_dag.ApiModuleComponent;
import com.example.raghu_gowda.dag2.api_dag.DaggerApiModuleComponent;
import com.example.raghu_gowda.dag2.api_dag.DaggerDataModulecomponent;
import com.example.raghu_gowda.dag2.api_dag.DaggerRetroProviderComponent;
import com.example.raghu_gowda.dag2.api_dag.DataModulecomponent;
import com.example.raghu_gowda.dag2.api_dag.RetroProviderComponent;


public final class PopularMoviesApplication extends Application{

    private RetroProviderComponent providerComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        providerComponent= DaggerRetroProviderComponent.builder()
                .apiModuleComponent(getApiModule())
                .build();
    }

    private ApiModuleComponent getApiModule() {
        return DaggerApiModuleComponent.builder()
                .dataModulecomponent(getDataModule())
                .build();
    }

    private DataModulecomponent getDataModule() {
        return DaggerDataModulecomponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }


    public RetroProviderComponent apiProvider(){
        return providerComponent;
    }


    public static PopularMoviesApplication get(Context context) {
        return (PopularMoviesApplication) context.getApplicationContext();
    }
}
/*
 private RetroProviderComponent providerComponent;

    @Override
    public void onCreate() {
        resolveDependencies();
        super.onCreate();
    }

    private void resolveDependencies() {
               providerComponent= DaggerRetroProviderComponent.builder()
                .apiModuleComponent(getApiComponent() )
                .build();
    }

    private ApiModuleComponent getApiComponent() {
        return DaggerApiModuleComponent.builder()
                .dataModulecomponent(getDatacomponent())
                .build();
    }

    private DataModulecomponent getDatacomponent() {
        return DaggerDataModulecomponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public RetroProviderComponent apiProvider(){
        return providerComponent;
    }
    public static PopularMoviesApplication get(Context context) {
        return (PopularMoviesApplication) context.getApplicationContext();
    }
 */