package com.bwf.framwork.share;

import android.content.Context;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class SharePrefreceHelper extends PrefrenceWrapper {

    private static SharePrefreceHelper sharePrefreceHelper;

    private SharePrefreceHelper(Context context) {
        super(context);
    }

    public static SharePrefreceHelper getInstence(Context context) {
        if (sharePrefreceHelper == null)
            sharePrefreceHelper = new SharePrefreceHelper(context);
        return sharePrefreceHelper;
    }


    @Override
    public void putString(String key, String value) {
        super.putString(key, value);
    }

    @Override
    public String getString(String key) {
        return super.getString(key);
    }

    @Override
    public String getString(String key, String defaultVaule) {
        return super.getString(key, defaultVaule);
    }

    @Override
    public void setBoolean(String key, boolean vaule) {
        super.setBoolean(key, vaule);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultVaule) {
        return super.getBoolean(key, defaultVaule);
    }
}
