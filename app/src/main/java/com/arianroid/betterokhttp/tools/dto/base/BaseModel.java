package com.arianroid.betterokhttp.tools.dto.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseModel {

    // ******************************************* Begin *******************************************

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    public static <T> T createModelFromJson(String object, Class<T> cls) {
        return getGson().fromJson(object, cls);
    }

    public String toJsonString() {
        return getGson().toJson(this);
    }

    // ******************************************** End ********************************************

}
