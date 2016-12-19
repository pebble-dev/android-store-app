package io.rebble.store.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.R;
import io.rebble.store.adapter.SectionAdapter;
import io.rebble.store.api.Api;
import io.rebble.store.api.model.Application;
import io.rebble.store.api.model.ApplicationIndexResult;
import io.rebble.store.api.model.Collection;
import io.rebble.store.viewmodel.section.CarouselSectionViewModel;
import io.rebble.store.viewmodel.section.ISectionViewModel;
import io.rebble.store.viewmodel.section.WatchFaceListSectionViewModel;
import rx.Subscriber;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    private Api mApi = new Api();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_watchface_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        setupRecyclerView(mRecyclerView);
        return view;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        loadDataFromServer();
    }

    private void loadDataFromServer() {
        List<ISectionViewModel> sectionViewModels = new ArrayList<>();
        CarouselSectionViewModel carouselViewModel = new CarouselSectionViewModel();
        sectionViewModels.add(carouselViewModel);

        Subscriber<ApplicationIndexResult> subscriber = new Subscriber<ApplicationIndexResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {
                String cause = throwable.getLocalizedMessage();
                Toast.makeText(getActivity(), cause, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(ApplicationIndexResult applicationIndexResult) {
                List<Application> applications = applicationIndexResult.applications;
                List<Collection> collections = applicationIndexResult.collections;
                List<ISectionViewModel> sectionViewModels = new ArrayList<>();
                for (int i = 0; i < collections.size(); i++) {
                    Collection collection = collections.get(i);
                    List<String> featuredApplicationIds = collection.applications;
                    List<Application> featuredApplications = new ArrayList<>();

                    for (int j = 0; j < featuredApplicationIds.size(); j++) {
                        Application application = findApplicationFromList(featuredApplicationIds.get(j), applications);
                        if (application != null) {
                            featuredApplications.add(application);
                        }
                    }

                    sectionViewModels.add(new WatchFaceListSectionViewModel(
                            (collection.name).toUpperCase(),
                            featuredApplications));
                }
                mRecyclerView.setAdapter(new SectionAdapter(sectionViewModels));
            }
        };

        mApi.getWatchfaceIndex(subscriber);
    }

    private Application findApplicationFromList(String appId, List<Application> applications) {
        for (int i = 0; i < applications.size(); i++) {
            Application application = applications.get(i);
            if (application.id.equals(appId)) {
                return application;
            }
        }
        return null;
    }
}
