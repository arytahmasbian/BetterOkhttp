package com.arianroid.betterokhttp.tools.task;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;

@SuppressWarnings({"unchecked", "unused"})
public class TaskHelper {

    public static <P, T extends AsyncTask<P, ?, ?>> void execute(T task) {
        execute(task, (P[]) null);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <P, T extends AsyncTask<P, ?, ?>> void execute(T task, P... params) {
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
    }

    // ************************** Serial ************************************

    public static <P, T extends AsyncTask<P, ?, ?>> void executeSerial(T task) {
        executeSerial(task, (P[]) null);
    }

    public static <P, T extends AsyncTask<P, ?, ?>> void executeSerial(T task, P... params) {
        task.execute(params);
    }


    // ******************************************** End ********************************************

}