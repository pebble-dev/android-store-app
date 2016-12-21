package io.rebble.store.adapter;

import android.view.View;

import java.util.List;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.command.LaunchWatchFaceApplicationDetailsActivityCommand;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListAdapter extends DataBindingBaseAdapter<WatchFaceApplicationViewModel> {
    public WatchFaceListAdapter(List<WatchFaceApplicationViewModel> mList) {
        super(mList);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.item_watchface;
    }

    @Override
    protected int getBRResId() {
        return BR.watchface;
    }

    @Override
    protected void onItemClicked(View view, WatchFaceApplicationViewModel item, int position) {
        LaunchWatchFaceApplicationDetailsActivityCommand command
                = new LaunchWatchFaceApplicationDetailsActivityCommand(view, item);
        command.execute();
    }

}
