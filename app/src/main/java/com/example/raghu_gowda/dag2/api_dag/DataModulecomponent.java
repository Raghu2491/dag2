package com.example.raghu_gowda.dag2.api_dag;


import com.example.raghu_gowda.dag2.ApplicationModule;
import com.example.raghu_gowda.dag2.GlideSetup;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Singleton
@Component(modules=DataModule.class,dependencies = {ApplicationModule.class})
public interface DataModulecomponent {

    void inject(GlideSetup glideSetup);

    OkHttpClient client();
}
