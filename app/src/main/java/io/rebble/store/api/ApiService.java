package io.rebble.store.api;

import io.rebble.store.api.model.ApplicationIndexResult;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zhangqichuan on 19/12/16.
 */

public interface ApiService {
    @GET("categories/index")
    Observable<ApplicationIndexResult> getApplicationIndex();


    @GET("categories/faces")
    Observable<ApplicationIndexResult> getWatchfaceIndex();
}
