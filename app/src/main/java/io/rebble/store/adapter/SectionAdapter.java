package io.rebble.store.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

import io.rebble.store.R;
import io.rebble.store.command.LaunchWatchFaceApplicationDetailsActivityCommand;
import io.rebble.store.util.BindingAdapterUtil;
import io.rebble.store.viewmodel.WatchFaceApplicationViewModel;
import io.rebble.store.viewmodel.section.ApplicationListSectionViewModel;
import io.rebble.store.viewmodel.section.CarouselSectionViewModel;
import io.rebble.store.viewmodel.section.BaseSectionViewModel;
import io.rebble.store.viewmodel.section.WatchFaceListSectionViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class SectionAdapter extends RecyclerView.Adapter {

    private List<BaseSectionViewModel> mSectionList;

    public SectionAdapter(List<BaseSectionViewModel> mSectionList) {
        this.mSectionList = mSectionList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BaseSectionViewModel.TYPE_WATCHFACES ||
                viewType == BaseSectionViewModel.TYPE_APPS) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.section_watchface_app_list, parent, false);
            return new ListSectionViewHolder(view);
        } else if (viewType == BaseSectionViewModel.TYPE_CAROUSEL) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.section_carousel, parent, false);
            return new CarouselSectionViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BaseSectionViewModel model = mSectionList.get(position);
        int viewType = getItemViewType(position);
        if (viewType == BaseSectionViewModel.TYPE_WATCHFACES) {
            WatchFaceListSectionViewModel viewModel = (WatchFaceListSectionViewModel) model;
            ListSectionViewHolder viewHolder = (ListSectionViewHolder) holder;
            RecyclerView.LayoutManager layoutManager = new
                    LinearLayoutManager(viewHolder.nameTextView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
            viewHolder.recyclerView.setLayoutManager(layoutManager);
            viewHolder.nameTextView.setText(viewModel.getName());
            viewHolder.recyclerView.setAdapter(new WatchFaceListAdapter(viewModel.getViewModelList()));
        } else if (viewType == BaseSectionViewModel.TYPE_APPS) {
            ApplicationListSectionViewModel viewModel = (ApplicationListSectionViewModel) model;
            ListSectionViewHolder viewHolder = (ListSectionViewHolder) holder;
            RecyclerView.LayoutManager layoutManager = new
                    LinearLayoutManager(viewHolder.nameTextView.getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
            viewHolder.recyclerView.setLayoutManager(layoutManager);
            viewHolder.nameTextView.setText(viewModel.getName());
            viewHolder.recyclerView.setAdapter(new ApplicationListAdapter(viewModel.getViewModelList()));
        } else if (viewType == BaseSectionViewModel.TYPE_CAROUSEL) {
            CarouselSectionViewModel viewModel = (CarouselSectionViewModel) model;
            CarouselSectionViewHolder viewHolder = (CarouselSectionViewHolder) holder;
            final List<WatchFaceApplicationViewModel> apps = viewModel.getViewModelList();
            viewHolder.carouselView.setPageCount(apps.size());
            viewHolder.carouselView.setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(final int position, ImageView imageView) {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            new LaunchWatchFaceApplicationDetailsActivityCommand(
                                            view.getContext(), apps.get(position)).execute();
                        }
                    });
                    BindingAdapterUtil.loadImage(imageView, apps.get(position).getBackdropImageUrl());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mSectionList.size();
    }


    private static class ListSectionViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public RecyclerView recyclerView;

        public ListSectionViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.text_name);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            recyclerView.setNestedScrollingEnabled(false);
        }
    }

    private static class CarouselSectionViewHolder extends RecyclerView.ViewHolder {
        public CarouselView carouselView;

        public CarouselSectionViewHolder(View itemView) {
            super(itemView);
            carouselView = (CarouselView) itemView.findViewById(R.id.carouselView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        BaseSectionViewModel viewModel = mSectionList.get(position);
        return viewModel.getType();
    }

}
