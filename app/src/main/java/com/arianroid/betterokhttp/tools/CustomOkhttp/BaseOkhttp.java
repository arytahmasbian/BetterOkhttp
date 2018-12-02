package com.arianroid.betterokhttp.tools.CustomOkhttp;

import android.os.AsyncTask;

import com.arianroid.betterokhttp.tools.task.TaskHelper;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class BaseOkhttp {

    // ******************** Constants ***********************
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    // ******************** Basic Functions *****************
    private static OkHttpClient getClient() {
        return new OkHttpClient().newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();
    }


    // ******************** Post ****************************


    private static BaseOkhttpResponse post(String url,
                                           JSONObject json,
                                           ArrayList<BasePairValue> parts,
                                           ArrayList<BasePairValue> headers) {

        RequestBody body = null;
        if (parts != null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (BasePairValue pair : parts)
                builder.addEncoded(pair.getKey(), pair.getValue());
            body = builder.build();
        }/* else if (json != null)
            body = RequestBody.create(JSON, json.toString());
        else body = RequestBody.create(JSON, "{}");
*/

        Request request =
                addHeaderToRequestBuilder(
                        new Request.Builder()
                                .url(url)
                                .post(body),
                        headers
                ).build();

        return callRequest(request);

    }


    public static BaseOkhttpResponse postInBackground(final String url,
                                                      final JSONObject json,
                                                      final BaseOkhttpRunnable runnable,
                                                      final ArrayList<BasePairValue> parts,
                                                      final ArrayList<BasePairValue> headers) {
        class Operation extends AsyncTask<Void, Void, BaseOkhttpResponse> {

            @Override
            protected BaseOkhttpResponse doInBackground(Void... voids) {
                return BaseOkhttp.post(url, json, parts, headers);
            }

            @Override
            protected void onPostExecute(BaseOkhttpResponse result) {
                super.onPostExecute(result);
                startRunnable(runnable, result);
            }
        }

        TaskHelper.execute(new Operation());

        return null;

    }

    // ******************** Get ****************************************
    private static BaseOkhttpResponse get(
            String url,
            ArrayList<BasePairValue> headers) {

        Request request =
                addHeaderToRequestBuilder(new Request
                                .Builder()
                                .url(url)
                                .get()
                        , headers).build();

        return callRequest(request);
    }

    public static BaseOkhttpResponse getInBackground(final String url,
                                                     final BaseOkhttpRunnable runnable,
                                                     final ArrayList<BasePairValue> headers) {
        class Operation extends AsyncTask<Void, Void, BaseOkhttpResponse> {

            @Override
            protected BaseOkhttpResponse doInBackground(Void... voids) {
                return BaseOkhttp.get(url, headers);
            }

            @Override
            protected void onPostExecute(BaseOkhttpResponse result) {
                super.onPostExecute(result);
                startRunnable(runnable, result);
            }
        }

        TaskHelper.execute(new Operation());

        return null;

    }


    // ******************** Add Header Functions ****************************
    private static Request.Builder addHeaderToRequestBuilder(Request.Builder builder,
                                                             ArrayList<BasePairValue> headers) {
        if (headers != null)
            for (BasePairValue header : headers)
                builder = builder.addHeader(header.getKey(), header.getValue());

        return builder;
    }


    // ******************** Call  Functions ****************************

    private static BaseOkhttpResponse callRequest(Request request) {
        Response response = null;
        try {
            Call call = getClient().newCall(request);
            response = call.execute();
            return new BaseOkhttpResponse(response.code(), response.body().string());
        } catch (IOException e) {
            return new BaseOkhttpResponse();
        }
    }


    // ******************  Helper Function *******************************

    private static void startRunnable(BaseOkhttpRunnable runnable, BaseOkhttpResponse response) {
        if (runnable != null)
            runnable.run(response);
    }


}
