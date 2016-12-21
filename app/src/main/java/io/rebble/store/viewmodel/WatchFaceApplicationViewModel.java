package io.rebble.store.viewmodel;

import io.rebble.store.api.model.Application;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceApplicationViewModel {

    private final Application application;

    public WatchFaceApplicationViewModel(Application application) {
        this.application = application;
    }

    public String getImageUrl() {
        return application.screenshotImages.get(0);
    }

    public String getBackdropImageUrl() {
        return application.bannerImage;
    }

    public String getName() {
        return application.title;
    }

    public String getLikes() {
        return String.valueOf(application.hearts);
    }

    public Application getDataModel() {
        return application;
    }
}
