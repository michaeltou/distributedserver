package com.tm.yunmo.common;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/5/24.
 */
public class JsonUtil {

    private static Gson gson = new Gson();

    public static String getString(Object object) {
        return gson.toJson(object);

    }

    public static <T> T getObject(String json, Class<T> classOfT){
        return gson.fromJson(json,classOfT);

    }

}
