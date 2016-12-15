package io.rebble.store.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public abstract class DataBindingBaseAdapter<T> extends
        RecyclerView.Adapter<DataBindingBaseAdapter.ViewHolder> {

    private List<T> mList;

    public DataBindingBaseAdapter(List<T> mList) {
        this.mList = mList;
    }

    @Override
    public DataBindingBaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        getLayoutResId(), parent, false);
        return new DataBindingBaseAdapter.ViewHolder(viewDataBinding);
    }

    @Override
    public void onBindViewHolder(DataBindingBaseAdapter.ViewHolder holder, int position) {
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(getBRResId(), mList.get(position));
        viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        if (mList == null) return 0;
        return mList.size();
    }

    protected abstract int getLayoutResId();

    protected abstract int getBRResId();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding mViewDataBinding;

        public ViewHolder(ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());
            mViewDataBinding = viewDataBinding;
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }

    }
}
