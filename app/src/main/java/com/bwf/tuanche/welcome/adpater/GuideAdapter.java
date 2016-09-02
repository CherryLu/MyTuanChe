package com.bwf.tuanche.welcome.adpater;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by BWF on 2016/8/31.
 */
public class GuideAdapter extends PagerAdapter {
    private int[] images;
    private ImageView[] imageViews;
    private Context context;

    public GuideAdapter(int[] images, Context context) {
        this.images = images;
        this.context = context;
        imageViews = new ImageView[images.length];
        for (int i = 0;i<images.length;i++){
            ImageView imageView = new ImageView(context);
            imageViews[i] = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(params);
        }
    }

    @Override
    public int getCount() {
        return images==null?0:images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        imageViews[position].setImageResource(images[position]);
        container.addView(imageViews[position]);
        return imageViews[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews[position]);
    }
}
