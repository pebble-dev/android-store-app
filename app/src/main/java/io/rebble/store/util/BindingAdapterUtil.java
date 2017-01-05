package io.rebble.store.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.rebble.store.adapter.SliderViewPagerAdapter;
import io.rebble.store.view.WatchFaceApplicationSliderView;
import io.rebble.store.viewmodel.SliderItemViewModel;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class BindingAdapterUtil {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        DrawableTypeRequest request = Glide.with(view.getContext()).load(url);
        if (url.endsWith(".gif")) {
            request.asGif().into(view);
        } else {
            request.into(view);
        }
    }

    @BindingAdapter("android:layout_width")
    public static void setLayoutWidth(View view, float width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) width;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("android:layout_height")
    public static void setLayoutHeight(View view, float height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) height;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter("bind:imageUrls")
    public static void setImageUrls(WatchFaceApplicationSliderView watchFaceApplicationSliderView,
                                    List<String> imageUrls) {
        if (imageUrls == null) {
            return;
        }
        List<SliderItemViewModel> viewModels = new ArrayList<>();
        for (int i = 0; i < imageUrls.size(); i++) {
            viewModels.add(new SliderItemViewModel(imageUrls.get(i)));
        }
        SliderViewPagerAdapter adapter = new SliderViewPagerAdapter(viewModels);
        watchFaceApplicationSliderView.setViewPagerAdapter(adapter);
    }

    @BindingAdapter("bind:coverImageUrl")
    public static void setCoverImageUrl(WatchFaceApplicationSliderView watchFaceApplicationSliderView,
                                        String coverImageUrl) {
        watchFaceApplicationSliderView.setCoverImageUrl(coverImageUrl);
    }
}
