package io.rebble.store.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;

/**
 * Created by zhangqichuan on 15/12/16.
 */

public class ImageUtil {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        DrawableTypeRequest request = Glide.with(view.getContext()).load(url);
        if (url.endsWith(".gif")) {
            request.asGif().into(view);
        } else {
            request.into(view);
        }
    }
}
