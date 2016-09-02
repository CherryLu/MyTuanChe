package com.bwf.tuanche.welcome.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.share.SharePrefreceHelper;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.R;

/**
 * Created by BWF on 2016/8/30.
 */
public class WelcomeActivity extends BaseActivity implements Handler.Callback {
    private Handler handler;


    @Override
    public int getContentViewId() {
        return R.layout.welcome_activity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        handler = new Handler(this);
        handler.sendEmptyMessageAtTime(1,2000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean handleMessage(Message message) {
        boolean flag = SharePrefreceHelper.getInstence(this).getBoolean("isFirst",false);
        if (message.what==1){
            if (flag){

            }else if (!flag){
                IntentUtils.openActivity(this,GuideActivity.class);
            }
        }
        return false;
    }
}
