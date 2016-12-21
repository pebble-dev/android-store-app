package io.rebble.store.viewmodel.section;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.api.model.Application;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public abstract class BaseSectionViewModel {
    public static int TYPE_APPS = 1;
    public static int TYPE_WATCHFACES = 2;
    public static int TYPE_CAROUSEL = 3;

    private List<WatchFaceApplicationViewModel> viewModelList;
    private String name;

    public BaseSectionViewModel(String name,
                                List<Application> list) {
        viewModelList = new ArrayList<>();
        for (Application application : list) {
            viewModelList.add(new WatchFaceApplicationViewModel(application));
        }
        this.name = name;
    }

    public List<WatchFaceApplicationViewModel> getViewModelList() {
        return viewModelList;
    }

    public String getName() {
        return name;
    }

    public abstract int getType();
}
