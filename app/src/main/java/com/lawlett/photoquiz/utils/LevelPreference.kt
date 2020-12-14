package com.lawlett.photoquiz.utils

import android.content.Context
import android.content.SharedPreferences


class LevelPreference(context: Context) {
    private val preferences: SharedPreferences
    val isShown: Boolean
        get() = preferences.getBoolean("isLevel", false)

    fun saveShown() {
        preferences.edit().putBoolean("isLevel", true).apply()
    }
    fun clearShown(){
        preferences.edit().clear().apply()
    }

    companion object {
        @Volatile
        var instance: LevelPreference? = null
        fun getInstance(context: Context): LevelPreference? {
            if (instance == null) LevelPreference(context)
            return instance
        }
    }

    init {
        instance = this
        preferences = context.getSharedPreferences("level", Context.MODE_PRIVATE)
    }
}
