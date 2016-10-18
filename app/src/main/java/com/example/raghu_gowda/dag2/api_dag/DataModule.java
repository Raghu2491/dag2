package com.example.raghu_gowda.dag2.api_dag;

import com.example.raghu_gowda.dag2.BuildConfig;
import android.app.AlertDialog;
import android.app.Application;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

@Module
public class DataModule {
    public static final int DISK_CACHE_SIZE = 50 * 1024 * 1024; // 50MB

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Application app) {
        return createOkHttpClient(app);
    }

    public OkHttpClient createOkHttpClient(Application app) {
        OkHttpClient client;


        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.readTimeout(10, SECONDS);
        builder.writeTimeout(10, SECONDS);
        builder.connectTimeout(10, SECONDS);
//        builder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request=chain.request();
//                HttpUrl url=request.url().newBuilder().addQueryParameter("api_key", BuildConfig.MOVIE_DB_API_KEY).build();
//                request.newBuilder().url(url).build();
//                return chain.proceed(request);
//
//            }
//        });

        File cacheDir = new File(app.getCacheDir(), "http");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

        builder.cache(cache);
        client=builder.build();
        return client;
    }
}
