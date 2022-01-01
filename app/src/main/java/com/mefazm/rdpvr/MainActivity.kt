package com.mefazm.rdpvr

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Button
import android.util.Log

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

        buttonConnect.setOnClickListener {
            Log.i(TAG, "Connect clicked.")
        }
    }
}
