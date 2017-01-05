package io.rebble.store.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rebble.store.R;
import io.rebble.store.adapter.SectionAdapter;
import io.rebble.store.api.Api;
import io.rebble.store.api.model.Application;
import io.rebble.store.api.model.ApplicationIndexResult;
import io.rebble.store.api.model.Collection;
import io.rebble.store.viewmodel.section.ApplicationListSectionViewModel;
import io.rebble.store.viewmodel.section.CarouselSectionViewModel;
import io.rebble.store.viewmodel.section.BaseSectionViewModel;
import io.rebble.store.viewmodel.section.WatchFaceListSectionViewModel;
import rx.Subscriber;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceApplicationListFragment extends Fragment {

    private static String EXTRA_TYPE = "LOAD_DATA_TYPE";
    public static int TYPE_WATCHFACES = 1;
    public static int TYPE_APPS = 2;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private Api mApi = new Api();

    public static WatchFaceApplicationListFragment create(int type) {
        WatchFaceApplicationListFragment watchFaceListFragment = new WatchFaceApplicationListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_TYPE, type);
        watchFaceListFragment.setArguments(bundle);
        return watchFaceListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_watchface_app_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        final boolean isWatchFaceType = getArguments().getInt(EXTRA_TYPE) == TYPE_WATCHFACES;
        Subscriber<ApplicationIndexResult> subscriber = new Subscriber<ApplicationIndexResult>() {
            @Override
            public void onCompleted() {
                mProgressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(Throwable throwable) {
                String cause = throwable.getLocalizedMessage();
                Toast.makeText(getActivity(), cause, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ApplicationIndexResult applicationIndexResult) {
                List<Application> applications = applicationIndexResult.applications;
                Map<String, Application> applicationCache = createApplicationCache(applications);
                List<Collection> collections = applicationIndexResult.collections;

                List<BaseSectionViewModel> sectionViewModels = new ArrayList<>();

                //Banner, use the first collection for now
                Collection bannerCollection = collections.get(0);
                CarouselSectionViewModel carouselSectionViewModel =
                        new CarouselSectionViewModel("",
                                getApplicationListFromCollection(bannerCollection, applicationCache));

                sectionViewModels.add(carouselSectionViewModel);

                for (int i = 0; i < collections.size(); i++) {
                    Collection collection = collections.get(i);
                    List<Application> featuredApplications
                            = getApplicationListFromCollection(collection, applicationCache);
                    if (isWatchFaceType) {
                        sectionViewModels.add(new WatchFaceListSectionViewModel(
                                (collection.name).toUpperCase(),
                                featuredApplications));
                    } else {
                        sectionViewModels.add(new ApplicationListSectionViewModel(
                                (collection.name).toUpperCase(),
                                featuredApplications));
                    }

                }
                mRecyclerView.setAdapter(new SectionAdapter(sectionViewModels));
            }

        };
        if (isWatchFaceType) {
            mApi.getWatchfaceIndex(subscriber);
        } else {
            mApi.getApplicationIndex(subscriber);
        }
    }

    private List<Application> getApplicationListFromCollection(Collection collection,
                                                               Map<String, Application> applicationCache){
        List<String> featuredApplicationIds = collection.applications;
        List<Application> applications = new ArrayList<>();

        for (int j = 0; j < featuredApplicationIds.size(); j++) {
            Application application =
                    applicationCache.get(featuredApplicationIds.get(j));
            if (application != null) {
                applications.add(application);
            }
        }
        return applications;
    }

    private Map<String, Application> createApplicationCache(List<Application> applications) {
        Map<String, Application> map = new HashMap<>();
        for (int i = 0; i < applications.size(); i++) {
            Application application = applications.get(i);
            map.put(application.id, application);
        }
        return map;
    }
}
