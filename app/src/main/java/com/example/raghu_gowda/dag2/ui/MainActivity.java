package com.example.raghu_gowda.dag2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.raghu_gowda.dag2.PopularMoviesApplication;
import com.example.raghu_gowda.dag2.R;
import com.example.raghu_gowda.dag2.api_dag.MoviesApi;
import com.example.raghu_gowda.dag2.model.EventResponse;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public String group_urlname="ny-tech";
    public static final String API_KEY="2f43365b380316d3a234157ae5e31";

    @Inject
    MoviesApi moviesApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((PopularMoviesApplication)getApplication())
                .apiProvider()
                .inject(MainActivity.this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        attachErrorHandler(moviesApi.getCategory(API_KEY,group_urlname))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<EventResponse>() {
                    @Override
                    public void call(EventResponse eventResponse) {
                        Log.d("--->",eventResponse.getResults().get(0).getName());
                    }
                });
    }
    private <T> Observable<T> attachErrorHandler(Observable<T> obs) {
        return obs.onErrorResumeNext(new Func1<Throwable, Observable<? extends T>>() {
            @Override
            public Observable<? extends T> call(Throwable throwable) {
                System.out.println("Handling error by printint to console: " + throwable);
                return Observable.empty();
            }
        });
    }
}
