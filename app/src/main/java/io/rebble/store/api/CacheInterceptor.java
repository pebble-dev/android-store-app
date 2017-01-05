package io.rebble.store.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by zhangqichuan on 2/1/17.
 */

public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed( chain.request() );

        // re-write response header to force use of cache
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge( 2, TimeUnit.MINUTES )
                .build();

        return response.newBuilder()
                .header( "Cache-Control", cacheControl.toString() )
                .build();
    }
}
