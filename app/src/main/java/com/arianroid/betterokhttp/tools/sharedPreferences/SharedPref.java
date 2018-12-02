package com.arianroid.betterokhttp.tools.sharedPreferences;


import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.arianroid.betterokhttp.tools.Tags;
import com.arianroid.betterokhttp.tools.application.MyApplicaiton;

public class SharedPref {

    private static SharedPreferences.Editor getEditor() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MyApplicaiton.busContext);
        return pref.edit();
    }

    private static SharedPreferences getSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(MyApplicaiton.busContext);
    }

    /********************** Getter & Setter method **********************/
    public static void setLastPopupTutorialDialogState(int state) {
        SharedPreferences.Editor editor = getEditor();
        editor.putInt(Tags.TUTORIAL_POPUP_MUST_SHOW, state);
        editor.apply();
    }

    public static int getLastReleaseNoteState() {
        SharedPreferences prefs = getSharedPreferences();
        return prefs.getInt(Tags.TUTORIAL_POPUP_MUST_SHOW, 0);
    }

}
