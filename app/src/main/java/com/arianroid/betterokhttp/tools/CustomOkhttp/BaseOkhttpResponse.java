package com.arianroid.betterokhttp.tools.CustomOkhttp;

import org.json.JSONArray;
import org.json.JSONException;


public class BaseOkhttpResponse {


    // *************************** Constants ********************
    public final static int UNKNOWN_CODE = 0;

    // **************************  Variables ********************

    private JSONArray bodyJsonArray;
    private String bodyString = "";
    private int statusCode;
    private boolean responseBodyIsJson;


    // ************************** Constructors ******************

    BaseOkhttpResponse() {
        this(UNKNOWN_CODE, "{}");
    }

    BaseOkhttpResponse(int statusCode, String body) {
        this.statusCode = statusCode;

        try {
            this.bodyJsonArray = new JSONArray(body);
            responseBodyIsJson = true;
        } catch (JSONException e) {
            responseBodyIsJson = false;
            bodyString = body;
        }
    }

    public BaseOkhttpResponse(int statusCode, JSONArray body) {
        this.bodyJsonArray = body;
        this.statusCode = statusCode;
        responseBodyIsJson = (body != null);
    }

    // ************************* Get Set Functions  *******************************
    public int getStatusCode() {
        return statusCode;
    }

    public String getBodyString() {
        return bodyString;
    }

    public JSONArray getBody() throws JSONException {

        if (bodyJsonArray == null) {
            try {
                this.bodyJsonArray = new JSONArray(bodyString);
                responseBodyIsJson = true;
            } catch (JSONException e) {
                responseBodyIsJson = false;
                bodyString = "";
                throw e;
            }
        }

        return bodyJsonArray;
    }

    // **************************  Functions  ********************************
    public boolean isSuccess() {
        return getStatusCode() == 200 || getStatusCode() == 201;
    }

    public boolean isBodyEmpty() {
        if (responseBodyIsJson)
            return bodyJsonArray.toString().isEmpty() || bodyJsonArray.toString().length() == 2;
        else return (bodyString.isEmpty() || bodyString.length() == 2) && bodyString.contains("{");
    }

    public boolean isBodyHasValue() {
        return !bodyString.isEmpty() || bodyString.length() != 0;
    }

    public boolean isTimeOut() {
        return bodyString.equals("time out");

    }

    public boolean isErrorData() {
        return bodyString.equals("error data");
    }

    public boolean isExist() {
        return bodyString.equals("exist");
    }

    public boolean isNotExist() {
        return bodyString.equals("not exist");
    }

    public boolean isOk() {
        return bodyString.equals("ok");
    }

    public boolean isErrorExist() {
        return bodyString.equals("error exist");
    }


    public boolean isServiceUnavailable() {
        return getStatusCode() != 200 && getStatusCode() !=201 ;
    }


    public boolean isResponseBodyJson() {
        return responseBodyIsJson;
    }

}
