package com.arianroid.betterokhttp.tools.api;

import android.util.Log;

import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttp;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttpResponse;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttpRunnable;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BasePairValue;
import com.arianroid.betterokhttp.tools.dto.base.BaseModel;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;


class GeneralApi {

    public static <T> ArrayList<Object> createObjectList(ArrayList<T> inputs) {
        if (inputs == null)
            return null;

        ArrayList<Object> objects = new ArrayList<>();

        for (T t : inputs)
            objects.add(t);

        return objects;
    }



    static <T> void getItemList(final Class<T> cls, String url, BaseOkhttpRunnable runnable, ArrayList<BasePairValue> pairs) {

        BaseOkhttp.postInBackground(url,
                null,
                runnable,
                pairs,
                ApiConfig.getHeaders());

    }

    static <T> ArrayList<T> getItemList(
            final Class<T> cls,
            String url,
            BaseOkhttpRunnable runnable) {

        //        BaseOkhttp.postInBackground(url,
        //                null,
        //                runnable,
        //                new ArrayList<>(),
        //                ApiConfig.getHeaders());


        BaseOkhttpResponse response = BaseOkhttp.get(url, ApiConfig.getHeaders());


        if (response.isSuccess()) {
            try {
                Type type = new ParameterizedType() {
                    @Override
                    public Type[] getActualTypeArguments() {
                        return new Type[]{cls};
                    }

                    @Override
                    public Type getOwnerType() {
                        return ArrayList.class;
                    }

                    @Override
                    public Type getRawType() {
                        return null;
                    }
                };

                return BaseModel.getGson().fromJson(response.getBody()
                        .getJSONArray(0).toString(), type);
            } catch (Exception e) {
                Log.i("Log", "getItemList: e :" + e.getMessage());
            }
        }
        return null;
    }


    static <T> void getItemList(String url, BaseOkhttpRunnable runnable) {
        BaseOkhttp.getInBackground(url,
                runnable,
                ApiConfig.getHeaders());

    }
}
