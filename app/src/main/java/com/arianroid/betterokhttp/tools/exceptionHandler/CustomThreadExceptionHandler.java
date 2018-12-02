package com.arianroid.betterokhttp.tools.exceptionHandler;


public class CustomThreadExceptionHandler implements Thread.UncaughtExceptionHandler {

    public CustomThreadExceptionHandler() {
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
//            Crashlytics.logException(e);
        } catch (Exception ignored) {
        } finally {
            System.exit(2);
        }
    }
}
