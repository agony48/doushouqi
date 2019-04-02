package com.color_analysis_in_xinjiangtimes.ui;

import cn.bmob.v3.BmobObject;

/**
 * Created by Administrator on 2018/10/18.
 */

public class Application_YYB extends BmobObject {
    private String isshow;
    private String app_url;
    private String app_name;

    public String getIsshow() {
        return isshow;
    }

    public void setIsshow(String isshow) {
        this.isshow = isshow;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getApp_name() {
        return app_name;
    }

    public void setApp_name(String app_name) {
        this.app_name = app_name;
    }

    @Override
    public String toString() {
        return "Application_YYB{" +
                "isshow='" + isshow + '\'' +
                ", app_url='" + app_url + '\'' +
                ", app_name='" + app_name + '\'' +
                '}';
    }
}
