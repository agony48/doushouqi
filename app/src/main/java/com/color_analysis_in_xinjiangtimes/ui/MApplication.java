package com.color_analysis_in_xinjiangtimes.ui;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * author 万强
 * date 16/5/10 上午11:54
 * desc ${TODO}
 */
public class MApplication extends Application {

    private List<Activity> activities = new ArrayList<>();

    private static MApplication application;

    public static MApplication getInstance() {
        if (application == null) {
            application = new MApplication();
        }
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
    }


    public void addCurrentActivity(Activity activity) {

        if (!activities.contains(activity)) {
            activities.add(activity);
        }

    }

    public void removeCurrentActivity(Activity activity) {
        if (activities.contains(activity)) {
            activities.remove(activity);
        }
    }

}
