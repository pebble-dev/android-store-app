package io.rebble.store.api;

import io.rebble.store.api.model.ApplicationIndexResult;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by zhangqichuan on 19/12/16.
 */

public interface ApiService {
    @GET("home/apps")
    Observable<ApplicationIndexResult> getApplicationIndex();


    @GET("home/watchfaces")
    Observable<ApplicationIndexResult> getWatchfaceIndex();
}
