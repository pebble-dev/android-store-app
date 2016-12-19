package io.rebble.store.viewmodel;

import io.rebble.store.api.model.Application;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceViewModel {

    private Application watchFace;

    public WatchFaceViewModel(Application watchFace) {
        this.watchFace = watchFace;
    }

    public String getImageUrl() {
        return watchFace.screenshotImages.get(0);
    }

    public String getName() {
        return watchFace.title;
    }

    public String getLikes() {
        return String.valueOf(watchFace.hearts);
    }
}
