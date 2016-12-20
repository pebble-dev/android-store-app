package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.api.model.Application;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class ApplicationListSectionViewModel extends WatchFaceListSectionViewModel {

    public ApplicationListSectionViewModel(String name, List<Application> list) {
        super(name, list);
    }

    @Override
    public int getType() {
        return ISectionViewModel.TYPE_APPS;
    }
}
