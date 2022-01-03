package com.mefazm.rdpvr

import com.mefazm.rdpvr.databinding.ActivityMainBinding

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(javaClass.name, "Create ${javaClass.name} instance.")
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textWatcher = fun(_: Editable?) {
            binding.buttonConnect.isEnabled =
                binding.editTextHostname.text.isNotEmpty() &&
                binding.editTextUsername.text.isNotEmpty() &&
                binding.editTextTextPassword.text.isNotEmpty()
        }

        binding.editTextHostname.doAfterTextChanged(textWatcher)
        binding.editTextUsername.doAfterTextChanged(textWatcher)
        binding.editTextTextPassword.doAfterTextChanged(textWatcher)

        binding.buttonConnect.setOnClickListener {
            Log.i(javaClass.name, "Connect clicked.")
            startActivity(Intent(this, SessionActivity::class.java))
        }
    }
}
