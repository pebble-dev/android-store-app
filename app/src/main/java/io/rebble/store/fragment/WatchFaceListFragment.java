package io.rebble.store.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.R;
import io.rebble.store.adapter.SectionAdapter;
import io.rebble.store.model.WatchFace;
import io.rebble.store.viewmodel.WatchFaceViewModel;
import io.rebble.store.viewmodel.section.ISectionViewModel;
import io.rebble.store.viewmodel.section.WatchFaceListSectionViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class WatchFaceListFragment extends Fragment {

    private RecyclerView mRecyclerView;

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
        List<ISectionViewModel> sectionViewModels = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sectionViewModels.add(new WatchFaceListSectionViewModel("Section " + i, getWatchFaceList()));
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new SectionAdapter(sectionViewModels));
    }

    private List<WatchFace> getWatchFaceList() {
        List<WatchFace> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WatchFace watchFace = new WatchFace();
            if (i % 2 == 0) {
                watchFace.imageUrl = "https://assets.getpebble.com/api/file/epP1ziuaRXKm7xqXuFxi/convert?cache=true&fit=crop&w=144&h=168";
            } else {
                watchFace.imageUrl = "https://assets.getpebble.com/api/file/F7Bqnaz8Qc26WQuEsfsI/convert?cache=true&fit=crop&w=144&h=168";
            }
            list.add(watchFace);
        }
        return  list;
    }
}
