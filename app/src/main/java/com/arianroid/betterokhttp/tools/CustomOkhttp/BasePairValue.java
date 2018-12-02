package com.arianroid.betterokhttp.tools.CustomOkhttp;

public class BasePairValue {
    private String key, value;

    public BasePairValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
