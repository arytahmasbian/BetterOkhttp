# Personalized OKHTTP
- Sample code of sending and receiving data
- MVP design pattern
- Using [Spinkit](https://github.com/ybq/Android-SpinKit) progressbar library
- Using personal tools for more comfort
- Better setting for gradle
## Screenshots

<p float="left">
<img src="https://media.giphy.com/media/1etm5M46leAc33R5vB/giphy.gif" width="280" height="480"/>
<img src="https://media.giphy.com/media/3JP8UTN6bFn2vbAUEf/giphy.gif" width="280" height="480"/>
<img src="https://user-images.githubusercontent.com/15871290/49337106-15831300-f623-11e8-8733-aba3f4fc4d73.jpg" width="280" height="480"/>
</p>

# Usage
- JSON (ReqResApi.java) / URL of JSON
```ReqResApi.java
private static final String API_URL = "https://reqres.in/api/users/";
```
- Starting Process (MainPresenter.java)
```MainPresenter.java
private void getUser() {

        if (InternetTools.isOnline()) {
            view.showWaiting();

            int fakeUserId = 2;
            ReqResApi.getUser(fakeUserId,
                    response -> {

                        if (response.isServiceUnavailable()) {
                            message = R.string.serverExceptionMessage;
                        } else {

                            //read json
                            Log.i("Log", "response is : " + response.getBodyString());

                            message = R.string.responseIsOk;

                        }

                        view.closeWaiting();
                        view.showMsg(message);

                    });
        } else {
            view.closeWaiting();
            view.showMsg(R.string.internetError);
        }


    }
```
If device is online this method gets the information from API and pass it as a OKHTTPResponse (response).
For parsing it into a DTO or get data by using this lines of code
```MainPresenter.java
response.getBodyString());
//Or as a json array but we need the index of array
try {
    response.getBody().getJSONArray(0); //Getting as array
    response.getBody().getJSONObject(0); //Getting as object
} catch (JSONException e) {
    e.printStackTrace();
}
```
# Tools
We got BaseActivity as a parent of any activity.
You can use it as a tool for Toolbar or Font for application or knowing stage of activty (Pause ,Resume and ...).
A Customized DTO or JSON parser in dto folder is ready to use and we got the Uncaught Exception Handler that you can use to handle the whole application exceptions or send it to Crashlytics.
You can use  ```InternetTools.isOnline();``` to know user is online or not.
Also we got Shared Preferences utility to cache user's data or a customized toast message ```MessageHelper.showMessage(this, msgId);``` for stored text in values/strings.xml  or ```MessageHelper.showMessage(this, "msgText");``` as a String.
You can also use CustomWebViewClient as a part of a WebView.
In PageCall we made methods to change activities and Animation is included in the App.

# Finaly
You can clone this repository, Rename it and use it in any kind of application.