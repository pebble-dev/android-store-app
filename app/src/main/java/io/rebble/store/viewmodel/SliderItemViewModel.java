package io.rebble.store.viewmodel;

/**
 * Created by zhangqichuan on 20/12/16.
 */

public class SliderItemViewModel {
    private final String imageUrl;

    public SliderItemViewModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public String getImageUrl() {
        return imageUrl;
    }
}
