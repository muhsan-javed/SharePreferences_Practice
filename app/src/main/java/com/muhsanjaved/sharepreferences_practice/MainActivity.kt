package com.muhsanjaved.sharepreferences_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.muhsanjaved.sharepreferences_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.editTextTextEmail.setText(editor.getString("email",null))
        binding.editTextTextPassword.setText(editor.getString("password",null))

        binding.btnLogin.setOnClickListener {

            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString("email",binding.editTextTextEmail.text.toString())
            editor.putString("password",binding.editTextTextPassword.text.toString())
            editor.apply()

            Toast.makeText(this,"Save",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,DataActivity::class.java))

        }


    }
}