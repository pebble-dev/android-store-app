package io.rebble.store.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.lapism.searchview.SearchView;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.fragment.WatchFaceApplicationListFragment;
import io.rebble.store.viewmodel.MainActivityViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private SearchView mSearchView;
    private NavigationView mNavigationView;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mSearchView = (SearchView) findViewById(R.id.searchView);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        setupViewpager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
        setupDrawer(mDrawerLayout, mToolbar, mSearchView);
        setupSearchView(mSearchView, mDrawerLayout);
        setupNavigationView(mNavigationView);
    }

    private void setupDrawer(DrawerLayout drawerLayout, Toolbar toolbar, final SearchView searchView) {
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (searchView != null && searchView.isSearchOpen()) {
                    searchView.close(true);
                }
            }
        };
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        drawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
    }

    private void setupViewpager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(WatchFaceApplicationListFragment.create(WatchFaceApplicationListFragment.TYPE_WATCHFACES), getString(R.string.watchfaces));
        viewPagerAdapter.addFragment(WatchFaceApplicationListFragment.create(WatchFaceApplicationListFragment.TYPE_APPS), getString(R.string.apps));
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupSearchView(SearchView searchView, final DrawerLayout drawerLayout) {
        searchView.setOnMenuClickListener(new SearchView.OnMenuClickListener() {
            @Override
            public void onMenuClick() {
                drawerLayout.openDrawer(GravityCompat.START); // finish();
            }
        });
    }

    private void setupNavigationView(NavigationView navigationView) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.nav_header, navigationView, false);
        dataBinding.setVariable(BR.main_activity_model, new MainActivityViewModel());
        dataBinding.executePendingBindings();
        navigationView.addHeaderView(dataBinding.getRoot());
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
