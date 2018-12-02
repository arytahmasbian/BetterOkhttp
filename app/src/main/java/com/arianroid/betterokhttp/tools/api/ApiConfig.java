package com.arianroid.betterokhttp.tools.api;

import com.arianroid.betterokhttp.tools.CustomOkhttp.BasePairValue;

import java.util.ArrayList;

public class ApiConfig {


    // **************************** HEADER *****************************
    static ArrayList<BasePairValue> getHeaders() {
        ArrayList<BasePairValue> headers = new ArrayList<>();
        headers.add(new BasePairValue("Content-Type", "application/x-www-form-urlencoded"));
        headers.add(new BasePairValue("Accept-Charset", "unicode"));
        headers.add(new BasePairValue("Charset", "unicode"));
        return headers;
    }


}

