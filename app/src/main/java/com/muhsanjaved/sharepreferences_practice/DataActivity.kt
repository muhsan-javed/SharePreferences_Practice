package com.muhsanjaved.sharepreferences_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhsanjaved.sharepreferences_practice.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor=getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.textViewEmail.setText("Hey your E-mail is ${editor.getString("email",null)}" )

        binding.textViewPassword.text = "Hey your Password is ${editor.getString("password",null)}"
    }
}