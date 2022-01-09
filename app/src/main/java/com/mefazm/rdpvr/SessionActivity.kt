package com.mefazm.rdpvr

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle

class SessionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Create instance.")
        super.onCreate(savedInstanceState)

        val sessionView = SessionView(this)
        setContentView(sessionView)
        connect(
            intent.getStringExtra("hostname")!!,
            intent.getStringExtra("username")!!,
            intent.getStringExtra("password")!!
        )
    }

    private external fun connect(hostname: String, username: String, password: String)

    companion object {
        init {
            System.loadLibrary("rdpvr")
        }
    }
}
