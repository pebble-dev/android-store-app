package io.rebble.store.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.BindingAdapter;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import io.rebble.store.R;
import io.rebble.store.util.BindingAdapterUtil;

/**
 * Created by zhangqichuan on 20/12/16.
 */

public class WatchFaceApplicationSliderView extends RelativeLayout {

    private ViewPager mViewPager;
    private ImageView mCoverImage;

    public WatchFaceApplicationSliderView(Context context) {
        super(context);
        setupView();
    }

    public WatchFaceApplicationSliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView();
    }

    public WatchFaceApplicationSliderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView();
    }

    private void setupView() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_watchface_app_slider, this);
        this.mViewPager = (ViewPager) findViewById(R.id.viewpager);
        this.mCoverImage = (ImageView) findViewById(R.id.img_cover);

        if (getContext() instanceof Activity) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        if (state != ViewPager.SCROLL_STATE_IDLE) {
                            mCoverImage.setVisibility(View.INVISIBLE);
                        } else {
                            mCoverImage.setVisibility(View.VISIBLE);
                        }
                    }
                });

                ((Activity) getContext()).getWindow().getSharedElementEnterTransition()
                        .addListener(new Transition.TransitionListener() {
                            @Override
                            public void onTransitionStart(Transition transition) {
                                mViewPager.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mViewPager.setVisibility(View.INVISIBLE);
                                        mCoverImage.setVisibility(View.VISIBLE);
                                    }
                                });
                            }

                            @Override
                            public void onTransitionEnd(Transition transition) {
                                mViewPager.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        mViewPager.setVisibility(View.VISIBLE);
                                        mCoverImage.setVisibility(View.INVISIBLE);
                                    }
                                });
                            }

                            @Override
                            public void onTransitionCancel(Transition transition) {

                            }

                            @Override
                            public void onTransitionPause(Transition transition) {

                            }

                            @Override
                            public void onTransitionResume(Transition transition) {

                            }
                        });
            }
        }
    }

    public void setViewPagerAdapter(PagerAdapter pagerAdapter) {
        mViewPager.setAdapter(pagerAdapter);
    }

    public void setCoverImageUrl(String url) {
        BindingAdapterUtil.loadImage(mCoverImage, url);
    }
}
