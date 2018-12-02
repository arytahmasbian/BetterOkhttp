package com.arianroid.betterokhttp.tools.api;

import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttp;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttpRunnable;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BasePairValue;

import java.util.ArrayList;


class GeneralApi {

    static <T> void getItemList(final Class<T> cls, String url, BaseOkhttpRunnable runnable, ArrayList<BasePairValue> pairs) {

        BaseOkhttp.postInBackground(url,
                null,
                runnable,
                pairs,
                ApiConfig.getHeaders());

    }

    static <T> void getItemList(final Class<T> cls, String url, BaseOkhttpRunnable runnable) {

        BaseOkhttp.postInBackground(url,
                null,
                runnable,
                new ArrayList<>(),
                ApiConfig.getHeaders());


        /*if (response.isSuccess()) {
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
                return ModelParser.getGson().fromJson(response.getBody().getJSONArray(Tags.DATA).toString(), type);
            } catch (Exception e) {
                return null;
            }
        }
        return null;*/
    }


    static <T> void getItemList(String url, BaseOkhttpRunnable runnable) {
        BaseOkhttp.getInBackground(url,
                runnable,
                ApiConfig.getHeaders());

    }
}
