package io.rebble.store.activity;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
        final ViewDataBinding viewDataBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_watchface_app_details);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getIntent() != null) {
            if (Intent.ACTION_VIEW.equals(getIntent().getAction())) {
                Uri uri = getIntent().getData();
                String appId = uri.getQueryParameter("app");
                Toast.makeText(getApplicationContext(),appId, Toast.LENGTH_SHORT).show();
            }
            else {
                if (getIntent().hasExtra(EXTRA_WATCHFACE_APP_DETAILS)) {
                    final Application application = getIntent().getParcelableExtra(EXTRA_WATCHFACE_APP_DETAILS); //hosts the data binding variables.
                    viewDataBinding.setVariable(BR.app, new WatchFaceApplicationDetailsViewModel((application)));

                    final Button appInstall = (Button)findViewById(R.id.install_app);
                    appInstall.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //App install now goes to browser. Needs to go to Gadgetbridge or Pebbleapp instead.
                            Intent openPbw = new Intent(Intent.ACTION_VIEW);
                            openPbw.setData(Uri.parse(application.pbwFile));
                            startActivity(openPbw);
                        }
                    });
                    final Button viewSource = (Button)findViewById(R.id.txt_source_url);
                    if (application.source.isEmpty()) {
                        viewSource.setVisibility(View.GONE);
                    }
                    viewSource.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent openSrc = new Intent(Intent.ACTION_VIEW);
                            openSrc.setData(Uri.parse(application.source));
                            startActivity(openSrc);
                        }
                    });

                    final Button viewWebsite = (Button)findViewById(R.id.txt_website_url);
                    if (application.website.isEmpty()) {
                        viewWebsite.setVisibility(View.GONE);
                    }
                    viewWebsite.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent openWww = new Intent(Intent.ACTION_VIEW);
                                openWww.setData(Uri.parse(application.website));
                                startActivity(openWww);

                        }
                    });
                }
            }

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
