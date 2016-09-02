package com.bwf.tuanche.test;

/**
 * Created by BWF on 2016/9/1.
 */
public class UpdateBean {
    public String versionCode;

    public String versionName;

    public String url;

    public String md5file;

    public String description;

    public String upgradeStringervalWarn;

    public String isFourceUpGrade;

    public String isPromtUpGrade;

    public String titleText;

    public String giveUpText;

    public String upgradeText;

    public String textPic;

    public String isForce;

    public String specificEdition;

    public String minVersion;

    @Override
    public String toString() {
        return "UpdateBean{" +
                "versionCode='" + versionCode + '\'' +
                ", versionName='" + versionName + '\'' +
                ", url='" + url + '\'' +
                ", md5file='" + md5file + '\'' +
                ", description='" + description + '\'' +
                ", upgradeStringervalWarn='" + upgradeStringervalWarn + '\'' +
                ", isFourceUpGrade='" + isFourceUpGrade + '\'' +
                ", isPromtUpGrade='" + isPromtUpGrade + '\'' +
                ", titleText='" + titleText + '\'' +
                ", giveUpText='" + giveUpText + '\'' +
                ", upgradeText='" + upgradeText + '\'' +
                ", textPic='" + textPic + '\'' +
                ", isForce='" + isForce + '\'' +
                ", specificEdition='" + specificEdition + '\'' +
                ", minVersion='" + minVersion + '\'' +
                '}';
    }
}
