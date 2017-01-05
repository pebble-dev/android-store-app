package io.rebble.store.command;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import io.rebble.store.R;
import io.rebble.store.activity.WatchFaceApplicationDetailsActivity;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;

/**
 * Created by zhangqichuan on 21/12/16.
 */

public class LaunchWatchFaceApplicationDetailsActivityCommand implements ICommand {
    private final Context mContext;
    private final WatchFaceApplicationViewModel mModel;
    private View mView;

    public LaunchWatchFaceApplicationDetailsActivityCommand(Context context, WatchFaceApplicationViewModel model) {
        this.mContext = context;
        this.mModel = model;
    }

    public LaunchWatchFaceApplicationDetailsActivityCommand(View view, WatchFaceApplicationViewModel mModel) {
        this.mContext = view.getContext();
        this.mModel = mModel;
        this.mView = view;
    }

    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void execute() {
        Intent intent = new Intent(mContext, WatchFaceApplicationDetailsActivity.class);
        intent.putExtra(WatchFaceApplicationDetailsActivity.EXTRA_WATCHFACE_APP_DETAILS, mModel.getDataModel());
        if (mContext instanceof Activity && mView != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) mContext,
                    new Pair<View, String>(mView.findViewById(R.id.img),
                            mContext.getString(R.string.transition_name_image)));
            ActivityCompat.startActivity(mContext, intent, options.toBundle());
        } else {
            mContext.startActivity(intent);
        }
    }
}
