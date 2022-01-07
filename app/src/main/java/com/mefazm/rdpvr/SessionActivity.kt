package com.mefazm.rdpvr

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log

class SessionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(javaClass.name, "Create ${javaClass.name} instance.")
        super.onCreate(savedInstanceState)

        val sessionView = SessionView(this)
        setContentView(sessionView)
        /* connect(
            intent.getStringExtra("hostname")!!,
            intent.getStringExtra("username")!!,
            intent.getStringExtra("password")!!
        ) */
        connect("𐎠𐎠𐎠", "𐎠𐎠𐎠", "𐎠𐎠𐎠")
    }

    private external fun connect(hostname: String, username: String, password: String)

    companion object {
        init {
            System.loadLibrary("rdpvr")
        }
    }
}
