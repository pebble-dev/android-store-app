package io.rebble.store;

import android.app.Application;

/**
 * Created by zhangqichuan on 2/1/17.
 */

public class StoreApplication extends Application {

    private static StoreApplication sInstance;

    public static StoreApplication getApplication() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
