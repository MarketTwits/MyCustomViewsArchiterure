package com.example.mycustomviewsarchiterure.core

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener

interface Storage {
    fun save(key: String, value: Boolean)
    fun read(key: String, default: Boolean): Boolean
    class Base(private val sharedPreferences: SharedPreferences) : Storage {
        override fun save(key: String, value: Boolean) {
            sharedPreferences.edit().putBoolean(key, value).apply()
        }

        override fun read(key: String, default: Boolean): Boolean =
            sharedPreferences.getBoolean(key, default)
    }
}