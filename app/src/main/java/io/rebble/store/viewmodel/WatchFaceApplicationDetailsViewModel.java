package io.rebble.store.viewmodel;

import java.util.List;

import io.rebble.store.api.model.Application;

/**
 * Created by zhangqichuan on 20/12/16.
 */

public class WatchFaceApplicationDetailsViewModel {
    private final Application application;

    public WatchFaceApplicationDetailsViewModel(Application application) {
        this.application = application;
    }

    public boolean isBackdropExpanded() {
        return application.bannerImage != null;
    }

    public String getBackdropImageUrl() {
        return application.bannerImage;
    }

    public String getProfileImageUrl() {
        return application.screenshotImages.get(0);
    }

    public List<String> getScreenshotImageUrls() {
        return application.screenshotImages;
    }

    public String getFirstScreenShotImageUrl() {
        return application.screenshotImages.get(0);
    }
}
