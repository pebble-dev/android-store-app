package io.rebble.store.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.rebble.store.R;
import io.rebble.store.viewmodel.section.ISectionViewModel;
import io.rebble.store.viewmodel.section.WatchFaceListSectionViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class SectionAdapter extends RecyclerView.Adapter {

    private List<ISectionViewModel> mSectionList;

    public SectionAdapter(List<ISectionViewModel> mSectionList) {
        this.mSectionList = mSectionList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == R.layout.section_watchface_list) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.section_watchface_list, parent, false);
            return new WatchFaceListSectionViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ISectionViewModel model = mSectionList.get(position);
        int viewType = getItemViewType(position);
        if (viewType == R.layout.section_watchface_list) {
            WatchFaceListSectionViewModel viewModel = (WatchFaceListSectionViewModel) model;
            WatchFaceListSectionViewHolder viewHolder = (WatchFaceListSectionViewHolder) holder;
            RecyclerView.LayoutManager layoutManager = new
                    LinearLayoutManager(viewHolder.nameTextView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
            viewHolder.watfaceRecyclerView.setLayoutManager(layoutManager);
            viewHolder.nameTextView.setText(viewModel.getName());
            viewHolder.watfaceRecyclerView.setAdapter(new WatchFaceListAdapter(viewModel.getViewModelList()));
        }
    }

    @Override
    public int getItemCount() {
        return mSectionList.size();
    }


    public static class WatchFaceListSectionViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public RecyclerView watfaceRecyclerView;

        public WatchFaceListSectionViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.text_name);
            watfaceRecyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            watfaceRecyclerView.setNestedScrollingEnabled(false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        //TODO return other view type i.e. Banner
        if (mSectionList.get(position) instanceof WatchFaceListSectionViewModel) {
            return R.layout.section_watchface_list;
        }
        return R.layout.section_watchface_list;
    }

}
