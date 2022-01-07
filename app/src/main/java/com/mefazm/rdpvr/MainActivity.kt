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
                binding.editTextPassword.text.isNotEmpty()
        }

        binding.editTextHostname.doAfterTextChanged(textWatcher)
        binding.editTextUsername.doAfterTextChanged(textWatcher)
        binding.editTextPassword.doAfterTextChanged(textWatcher)

        binding.buttonConnect.setOnClickListener {
            Log.i(javaClass.name, "Connect clicked.")
            startActivity(Intent(this, SessionActivity::class.java).apply {
                putExtra("hostname", binding.editTextHostname.text.toString())
                putExtra("username", binding.editTextUsername.text.toString())
                putExtra("password", binding.editTextPassword.text.toString())
            })
        }
    }
}
