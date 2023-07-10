package com.muhsanjaved.sharepreferences_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.muhsanjaved.sharepreferences_practice.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        val user = Gson().fromJson(editor.getString("USER_DATA",null),User::class.java)

        binding.textViewEmail.setText("Hey your E-mail is ${user.email}" )

        binding.textViewPassword.text = "Hey your Password is ${user.password}"
    }
}