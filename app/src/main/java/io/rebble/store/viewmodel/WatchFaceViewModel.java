package io.rebble.store.viewmodel;

import io.rebble.store.model.WatchFace;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceViewModel {

    private WatchFace watchFace;

    public WatchFaceViewModel(WatchFace watchFace) {
        this.watchFace = watchFace;
    }

    public String getImageUrl() {
        return watchFace.imageUrl;
    }

    public String getName() {
        return watchFace.name;
    }

    public String getLikes() {
        return String.valueOf(watchFace.likes);
    }
}
