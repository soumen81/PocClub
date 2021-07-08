package com.autumntechcreation.pocclub.sharedpref

import android.content.Context
import android.content.SharedPreferences
import com.autumntechcreation.pocclub.R
import com.autumntechcreation.pocclub.sharedpref.Preference.ENTERED_HOME_ACTIVITY

object Preference {
    const val ENTERED_HOME_ACTIVITY="ENTERED_HOME_ACTIVITY"





fun getInstance(context: Context): SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)
}



fun SharedPreferences.set(key: String, it: Int){
    val editor: SharedPreferences.Editor = this.edit()
    editor.putInt(key, it)
    editor.apply()
}

fun SharedPreferences.set(key: String, it: String) {
    val editor: SharedPreferences.Editor = this.edit()
    editor.putString(key, it)
    editor.apply()
}

fun SharedPreferences.set(key: String, it: Boolean){
    val editor: SharedPreferences.Editor = this.edit()
    editor.putBoolean(key, it)
    editor.apply()
}

fun SharedPreferences.get(key: String, defaultValue: Int): Int {
    return getInt(key, defaultValue)
}

fun SharedPreferences.get(key: String, defaultValue: String): String {
    return getString(key, defaultValue).toString()
}

fun SharedPreferences.get(key: String, defaultValue: Boolean): Boolean {
    return getBoolean(key, defaultValue)
}


fun SharedPreferences.deleteForLogOut(){
    val editor: SharedPreferences.Editor = this.edit()


    editor.remove(ENTERED_HOME_ACTIVITY).apply()
}
