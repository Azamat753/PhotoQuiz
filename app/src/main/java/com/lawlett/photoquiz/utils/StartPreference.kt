package com.lawlett.photoquiz.utils

import android.content.Context
import android.content.SharedPreferences


class StartPreference(context: Context) {
    private val preferences: SharedPreferences
    val isShown: Boolean
        get() = preferences.getBoolean("isShown", false)

    fun saveShown() {
        preferences.edit().putBoolean("isShown", true).apply()
    }

    companion object {
        @Volatile
        var instance: StartPreference? = null
        fun getInstance(context: Context): StartPreference? {
            if (instance == null) StartPreference(context)
            return instance
        }
    }

    init {
        instance = this
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }
}
