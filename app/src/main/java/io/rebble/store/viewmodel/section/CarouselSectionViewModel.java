package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.viewmodel.CarouselItemViewModel;

/**
 * Created by zhangqichuan on 17/12/16.
 */

public class CarouselSectionViewModel implements ISectionViewModel {

    private List<String> items;

    public CarouselSectionViewModel() {
        items = new ArrayList<>();
        //TODO get the images from API
        items.add("https://assets.getpebble.com/api/file/zGgJadGcQgS3hx6QtdLx/convert?cache=true&fit=crop&w=720&h=320");
        items.add("https://assets.getpebble.com/api/file/wiYVK4TdTSGdiHb1i9T6/convert?cache=true&fit=crop&w=720&h=320");
        items.add("https://assets.getpebble.com/api/file/jD3adfRC2p58NEirTLig/convert?cache=true&fit=crop&w=720&h=320");
    }

    public List<String> getCarouselImages() {
        return items;
    }

    @Override
    public int getType() {
        return ISectionViewModel.TYPE_CAROUSEL;
    }
}
