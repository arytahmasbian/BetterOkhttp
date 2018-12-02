package com.arianroid.betterokhttp.tools.api;


import com.arianroid.betterokhttp.tools.CustomOkhttp.BaseOkhttpRunnable;
import com.arianroid.betterokhttp.tools.CustomOkhttp.BasePairValue;
import com.arianroid.betterokhttp.tools.Tags;

import java.util.ArrayList;

public class ReqResApi {

    // ****************** URL *************************
    private static final String API_URL = "https://reqres.in/api/users/";

    // ****************** API ********************
    public static void getUser(int userId, BaseOkhttpRunnable runnable) {

        String userUrl = API_URL + userId;

        GeneralApi.getItemList(userUrl, runnable);
    }

    public static void createUser(
            String name,
            String job,
            BaseOkhttpRunnable runnable) {

        ArrayList<BasePairValue> pairs = new ArrayList<>();
        pairs.add(new BasePairValue(Tags.NAME, name));
        pairs.add(new BasePairValue(Tags.JOB, job));

        GeneralApi.getItemList(null, API_URL, runnable, pairs);
    }


}
