package io.rebble.store.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.List;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.activity.WatchFaceApplicationDetailsActivity;
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

    @Override
    protected void onItemClicked(View view, WatchFaceApplicationViewModel item, int position) {
        Context context = view.getContext();
        Intent intent = new Intent(context, WatchFaceApplicationDetailsActivity.class);
        intent.putExtra(WatchFaceApplicationDetailsActivity.EXTRA_WATCHFACE_APP_DETAILS, item.getDataModel());
        if (context instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                    new Pair<View, String>(view.findViewById(R.id.img),
                            context.getString(R.string.transition_name_image)));
            ActivityCompat.startActivity(context, intent, options.toBundle());
        } else {
            view.getContext().startActivity(intent);
        }
    }
}
