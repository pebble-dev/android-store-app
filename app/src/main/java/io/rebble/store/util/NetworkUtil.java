package io.rebble.store.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import io.rebble.store.StoreApplication;

/**
 * Created by zhangqichuan on 2/1/17.
 */

public class NetworkUtil {
    public static boolean hasNetwork() {
        StoreApplication storeApplication = StoreApplication.getApplication();
        if (storeApplication != null) {
            ConnectivityManager cm = (ConnectivityManager) storeApplication
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }
        return false;
    }
}
