package com.arianroid.betterokhttp.tools.views.message;


import android.app.Activity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arianroid.betterokhttp.R;

public class MessageHelper {
    private static Toast endToast = null;

    private static void cancelMessage() {
        if (endToast != null)
            endToast.cancel();
    }

    public static void showMessage(Activity context, int textId) {
        if (textId == 0)
            return;

        showMessage(context, context.getString(textId), Toast.LENGTH_LONG);
    }

    public static void showMessage(Activity context, String text) {
        if (text.isEmpty())
            return;

        showMessage(context, text, Toast.LENGTH_LONG);
    }

    private static void showMessage(Activity context, String text, int duration) {
        cancelMessage();
        Toast toast = new Toast(context);

        LinearLayout layout = (LinearLayout) context.getLayoutInflater().
                inflate(R.layout.custome_toast_layout, null);
        toast.setView(layout);

        TextView textView = (TextView) layout.findViewById(R.id.txtToast);
        text += " ";
        textView.setText(text);

        toast.setDuration(duration);

        endToast = toast;
        toast.show();

    }
}
