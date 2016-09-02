package com.bwf.tuanche.city.bean;

import java.util.List;

/**
 * Created by BWF on 2016/8/31.
 */
public class CityResultBean {
        public List<CityBean> hotCitys;
        public List<CityBean> openCitys;


    @Override
    public String toString() {
        return "CityResultBean{" +
                "hotCitys=" + hotCitys +
                ", openCitys=" + openCitys +
                '}';
    }
}
