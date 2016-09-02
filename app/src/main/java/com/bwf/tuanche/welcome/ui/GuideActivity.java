package com.bwf.tuanche.welcome.ui;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.PrefrenceWrapper;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.welcome.adpater.GuideAdapter;

/**
 * Created by BWF on 2016/8/31.
 */
public class GuideActivity extends BaseActivity {
    private ViewPager guide_viewpager;
    private Button star_button;
    private GuideAdapter adapter;
    private int[] images;
    @Override
    public int getContentViewId() {
        return R.layout.guide_activity;
    }

    @Override
    public void beforeInitView() {
        SharePrefreceHelper.getInstence(this).setBoolean("isFirst",true);
    }

    @Override
    public void initView() {
        guide_viewpager = findViewByIdNoCast(R.id.guide_viewpager);
        star_button = findViewByIdNoCast(R.id.star_button);
        star_button.setOnClickListener(this);
    }

    @Override
    public void initData() {
        images = new int[]{R.mipmap.guide01,R.mipmap.guide02};
        adapter = new GuideAdapter(images,this);
        guide_viewpager.setAdapter(adapter);
        guide_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                    if (position==1){
                        star_button.setVisibility(View.VISIBLE);
                    }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.star_button:
                break;
        }

    }
}
