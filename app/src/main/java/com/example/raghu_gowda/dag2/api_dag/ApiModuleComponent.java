package com.example.raghu_gowda.dag2.api_dag;

import com.example.raghu_gowda.dag2.ui.MainActivity;

import dagger.Component;
import retrofit2.Retrofit;

@CustomScope
@Component(modules = ApiModule.class,dependencies = {DataModulecomponent.class})
public interface ApiModuleComponent {

    Retrofit retrofit();
}
