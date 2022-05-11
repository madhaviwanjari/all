package com.example.registrationformapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Utility {

    public static void printLog(String tag,String msg){
        Log.d(tag,msg);
    }

    public static SharedPreferences getSharedPref(Context context){
        return context.getSharedPreferences("sharedPrefFile", Context.MODE_PRIVATE);
    }

    public static void savePref(Context context,String key,String value){
        SharedPreferences pref = Utility.getSharedPref(context);
        SharedPreferences.Editor edit= pref.edit();
        edit.putString(key,value);
        edit.commit();
    }

    public static String getPrefValue(Context context,String key){
        return getSharedPref(context).getString(key,"");

    }

    public static void savePref(Context context,String key,boolean value){
        SharedPreferences pref = Utility.getSharedPref(context);
        SharedPreferences.Editor edit= pref.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }


    public static boolean getPrefBooleanValue(Context context, String key){
        return getSharedPref(context).getBoolean(key,false);

    }
}
