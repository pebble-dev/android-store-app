package io.rebble.store.viewmodel;

import io.rebble.store.BuildConfig;

/**
 * Created by zhangqichuan on 4/1/17.
 */

public class MainActivityViewModel {

    public String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }
}
