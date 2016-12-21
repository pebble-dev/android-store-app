package io.rebble.store.viewmodel.section;

import java.util.List;

import io.rebble.store.api.model.Application;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListSectionViewModel extends BaseSectionViewModel {


    public WatchFaceListSectionViewModel(String name, List<Application> list) {
        super(name, list);
    }

    @Override
    public int getType() {
        return BaseSectionViewModel.TYPE_WATCHFACES;
    }
}
