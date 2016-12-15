package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.model.WatchFace;
import io.rebble.store.viewmodel.WatchFaceViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListSectionViewModel implements ISectionViewModel {

    private List<WatchFaceViewModel> viewModelList;

    private String name;

    public WatchFaceListSectionViewModel(String name, List<WatchFace> list) {
        viewModelList = new ArrayList<>();
        for (WatchFace watchFace : list) {
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
