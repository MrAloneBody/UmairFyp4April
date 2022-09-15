package com.example.umairfyp.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefrenceManager1 {

    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public PrefrenceManager1(Context context){
        sharedPreferences = context.getSharedPreferences(Constants.KEY_PREFERENCE_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void putBoolean(String key,Boolean value){
        editor.putBoolean(key,value);
        editor.apply();
    }


    public Boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key,false);
    }

    public void putString(String key,String value){
        editor.putString(key, value);
        editor.apply();

    }

    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }

    public void clear(){
        editor.clear();
        editor.apply();
    }


}
