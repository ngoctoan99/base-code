package com.toan.example.data.local

import android.content.SharedPreferences
import javax.inject.Inject


class SettingPreferences @Inject constructor( private val sharedPreferences: SharedPreferences) {

    companion object {
        private const val BASE_PREFS_LOCAL = "BASE_PREFS_LOCAL"
        private const val KEY_IS_DARK_MODE = "is_dark_mode"
    }

    fun setDarkMode(isDarkMode: Boolean) {
        sharedPreferences.edit().putBoolean(KEY_IS_DARK_MODE, isDarkMode).apply()
    }

    fun isDarkMode(): Boolean {
        return sharedPreferences.getBoolean(KEY_IS_DARK_MODE, true)
    }

}