package io.rebble.store.api;

import android.util.Log;

import java.io.File;

import io.rebble.store.StoreApplication;
import io.rebble.store.api.model.ApplicationIndexResult;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
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
                .client(provideOkHttpClient())
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

    private OkHttpClient provideOkHttpClient ()
    {
        return new OkHttpClient.Builder()
                .addInterceptor( new OfflineCacheInterceptor() )
                .addNetworkInterceptor( new CacheInterceptor() )
                .cache( provideCache() )
                .build();
    }

    private Cache provideCache() {
        Cache cache = null;
        try {
            cache = new Cache(new File(StoreApplication.getApplication()
                    .getCacheDir(), "http-cache"),
                    10 * 1024 * 1024); // 10 MB
        } catch (Exception e) {
            Log.e("Rebble", "Could not create Cache!");
        }
        return cache;
    }
}
