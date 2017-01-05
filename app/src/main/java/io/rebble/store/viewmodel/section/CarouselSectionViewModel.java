package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.api.model.Application;

/**
 * Created by zhangqichuan on 17/12/16.
 */

public class CarouselSectionViewModel extends BaseSectionViewModel {


    public CarouselSectionViewModel(String name, List<Application> list) {
        super(name, list);
    }

    @Override
    public int getType() {
        return BaseSectionViewModel.TYPE_CAROUSEL;
    }
}
