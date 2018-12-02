package com.arianroid.betterokhttp.tools.dto;

import com.google.gson.annotations.SerializedName;

public class UserDto {


        @SerializedName("id")
        public Integer id;
        @SerializedName("first_name")
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;
}
