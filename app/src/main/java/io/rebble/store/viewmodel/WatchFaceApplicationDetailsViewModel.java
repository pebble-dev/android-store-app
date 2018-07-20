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
        return application.headerImages.get(0) != null;
    }

    public String getBackdropImageUrl() {
        return application.headerImages.get(0);
    }

    public String getTitle() {
        return application.title.toUpperCase();
    }

    public String getAuthor() {
        return application.author;
    }

    public List<String> getScreenshotImageUrls() {
        return application.screenshotImages;
    }

    public String getFirstScreenShotImageUrl() {
        return application.screenshotImages.get(0);
    }

    public String getDescription() {
        return application.description;
    }

    public String getCategory() {
        return application.categoryName;
    }

    public String getUpdated() {
        return application.publishedDate;
    }

    public String getVersion() {
        return application.latestRelease.version;
    }

    public String getUUID() {
        return application.uuid;
    }

    public String getPbwFile() {
        return application.latestRelease.pbwFile;
    }

    public String getWebsite() {
        return application.website;
    }

    public String getSource() {
        return application.source;
    }
}
