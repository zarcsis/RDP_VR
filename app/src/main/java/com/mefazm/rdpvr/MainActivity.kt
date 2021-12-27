package com.mefazm.rdpvr

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "MainActivity")
    }

    fun getWindowSize() {
        Log.i(TAG, "SDK API Level: ${Build.VERSION.SDK_INT}")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            TODO("Get Window size for 31 API.")
        } else {
            TODO("Get Window size for 29 API.")
        }
    }
}
