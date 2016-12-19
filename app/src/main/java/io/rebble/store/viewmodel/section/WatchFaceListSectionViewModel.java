package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.api.model.Application;
import io.rebble.store.viewmodel.WatchFaceViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListSectionViewModel implements ISectionViewModel {

    private List<WatchFaceViewModel> viewModelList;

    private String name;

    public WatchFaceListSectionViewModel(String name, List<Application> list) {
        viewModelList = new ArrayList<>();
        for (Application watchFace : list) {
            viewModelList.add(new WatchFaceViewModel(watchFace));
        }
        this.name = name;
    }

    public List<WatchFaceViewModel> getViewModelList() {
        return viewModelList;
    }

    public String getName() {
        return name;
    }
}
