package com.mefazm.rdpvr

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Button
import android.util.Log
import androidx.core.widget.doAfterTextChanged

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "MainActivity")

        val editTextHostname = findViewById<EditText>(R.id.editTextHostname)
        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val buttonConnect = findViewById<Button>(R.id.buttonConnect)

        val textWatcher = fun(_: Editable?) {
            buttonConnect.isEnabled =
                editTextHostname.text.isNotEmpty() &&
                editTextUsername.text.isNotEmpty() &&
                editTextTextPassword.text.isNotEmpty()
        }

        editTextHostname.doAfterTextChanged(textWatcher)
        editTextUsername.doAfterTextChanged(textWatcher)
        editTextTextPassword.doAfterTextChanged(textWatcher)
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
