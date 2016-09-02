package com.bwf.tuanche.city.ui;

import android.view.View;
import android.widget.ListView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.tuanche.R;
import com.bwf.tuanche.city.adapter.CityAdapter;
import com.bwf.tuanche.city.bean.CityResultBean;

/**
 * Created by BWF on 2016/8/31.
 */
public class CitySelectActivity extends BaseActivity {
    private ListView city_listview;
    private CityAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.cityselect_activity;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        city_listview = findViewByIdNoCast(R.id.city_listview);
    }

    @Override
    public void initData() {
        HttpHelper.getCitySelect(new HttpCallBack<CityResultBean>() {
            @Override
            public void onSuccess(CityResultBean result) {
                    if (result!=null){
                       adapter = new CityAdapter(CitySelectActivity.this,result.openCitys);
                        city_listview.setAdapter(adapter);
                    }
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }

    @Override
    public void onClick(View view) {

    }
}
