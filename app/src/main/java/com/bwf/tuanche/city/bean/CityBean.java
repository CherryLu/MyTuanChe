package com.bwf.tuanche.city.bean;

/**
 * Created by BWF on 2016/8/31.
 */
public class CityBean {
    public String id;
    public String name;
    public String province;
    public String pinyin;
    public String citycode;
    public String pname;
    public String py;
    public String openStatus;
    public String manNum;


    @Override
    public String toString() {
        return "CityBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", province='" + province + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", pname='" + pname + '\'' +
                ", py='" + py + '\'' +
                ", openStatus='" + openStatus + '\'' +
                ", manNum='" + manNum + '\'' +
                '}';
    }
}
