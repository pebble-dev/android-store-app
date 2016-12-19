package io.rebble.store.api;

import io.rebble.store.api.model.ApplicationIndexResult;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangqichuan on 19/12/16.
 */

public class Api {

    private final ApiService mApiService;

    public Api() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dev-portal.getpebble.com/api/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    public void getApplicationIndex(Subscriber<ApplicationIndexResult> subscriber) {
        mApiService.getApplicationIndex()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getWatchfaceIndex(Subscriber<ApplicationIndexResult> subscriber) {
        mApiService.getWatchfaceIndex()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
