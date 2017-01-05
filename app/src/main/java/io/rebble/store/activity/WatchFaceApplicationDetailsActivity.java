package io.rebble.store.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.api.model.Application;
import io.rebble.store.viewmodel.WatchFaceApplicationDetailsViewModel;

/**
 * Created by zhangqichuan on 20/12/16.
 */

public class WatchFaceApplicationDetailsActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    public final static String EXTRA_WATCHFACE_APP_DETAILS = "EXTRA_WATCHFACE_APP_DETAILS";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_watchface_app_details);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (getIntent() != null && getIntent().hasExtra(EXTRA_WATCHFACE_APP_DETAILS)) {
            Application application = getIntent().getParcelableExtra(EXTRA_WATCHFACE_APP_DETAILS);
            viewDataBinding.setVariable(BR.app, new WatchFaceApplicationDetailsViewModel((application)));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
