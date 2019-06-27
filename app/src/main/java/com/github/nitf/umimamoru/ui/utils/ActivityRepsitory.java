package com.github.nitf.umimamoru.ui.utils;

import com.github.nitf.umimamoru.ui.activity.InfoDisplayActivity;
import com.github.nitf.umimamoru.ui.activity.MainActivity;
import com.github.nitf.umimamoru.ui.activity.SelectRegionActivity;

import java.util.HashMap;
import java.util.Map;

public class ActivityRepsitory {

    private static Map<String, Class> activityMap = new HashMap<String, Class>() {
        {
            put("Main", MainActivity.class);
            put("SelectRegion", SelectRegionActivity.class);
            put("InfoDisplay", InfoDisplayActivity.class);
        }
    };

    private static String nowActivity;

    public static void setNowActivity(String nowActivity) {
        ActivityRepsitory.nowActivity = nowActivity;
    }

    public static Class getNowActivityClass() {
        return getActivity(nowActivity);
    }

    public static Class getActivity(String name) {
        return activityMap.get(name);
    }

    public static void addActivity(String name, Class classObject) {
        activityMap.put(name, classObject);
    }

    public static void removeActivity(String name) {
        activityMap.remove(name);
    }
}
