package io.rebble.store.adapter;

import java.util.List;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;

/**
 * Created by zhangqichuan on 19/12/16.
 */

public class ApplicationListAdapter extends DataBindingBaseAdapter<WatchFaceApplicationViewModel> {
    public ApplicationListAdapter(List<WatchFaceApplicationViewModel> mList) {
        super(mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_app;
    }

    @Override
    protected int getBRResId() {
        return BR.app;
    }
}
