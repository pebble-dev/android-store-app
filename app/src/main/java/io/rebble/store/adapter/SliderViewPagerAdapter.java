package io.rebble.store.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import io.rebble.store.BR;
import io.rebble.store.R;
import io.rebble.store.viewmodel.SliderItemViewModel;

/**
 * Created by zhangqichuan on 20/12/16.
 */

public class SliderViewPagerAdapter extends PagerAdapter {

    private List<SliderItemViewModel> items;

    public SliderViewPagerAdapter(List<SliderItemViewModel> items) {
        this.items = items;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewDataBinding viewDataBinding =
                DataBindingUtil.inflate(LayoutInflater.from(container.getContext()),
                        R.layout.item_slider, container, false);
        viewDataBinding.setVariable(BR.item, items.get(position));
        View view = viewDataBinding.getRoot();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
