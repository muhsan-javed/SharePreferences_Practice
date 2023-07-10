package com.muhsanjaved.sharepreferences_practice

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.google.gson.Gson
import com.muhsanjaved.sharepreferences_practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
     private lateinit var listener:OnSharedPreferenceChangeListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.editTextTextEmail.setText(editor.getString("email",null))
        binding.editTextTextPassword.setText(editor.getString("password",null))

//        val user = Gson().fromJson(editor.getString("USER_DATA",null),User::class.java)
//        binding.editTextTextEmail.setText(user.email)
//        binding.editTextTextPassword.setText(user.password)

        binding.btnLogin.setOnClickListener {

            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString("email",binding.editTextTextEmail.text.toString())
            editor.putString("password",binding.editTextTextPassword.text.toString())
//            val user = User(binding.editTextTextEmail.text.toString(), binding.editTextTextPassword.text.toString())
//            val gson = Gson()
//            val Data = gson.toJson(user,User::class.java)
//            editor.putString("USER_DATA",Data)
            editor.apply()

            Toast.makeText(this,"Save",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,DataActivity::class.java))

        }

        binding.settingButton.setOnClickListener {
            startActivity(Intent(this,SettingsActivity::class.java))
        }

        val manager = PreferenceManager.getDefaultSharedPreferences(this)
        listener= SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key.equals("change_UI")){
                if (manager.getBoolean("change_UI", false) == true){
                    binding.mainLayout.setBackgroundColor(Color.DKGRAY)
                }else{
                    binding.mainLayout.setBackgroundColor(Color.WHITE)
                }

            }
        }

        manager.registerOnSharedPreferenceChangeListener(listener)

        binding.btnRemoveData.setOnClickListener {
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.clear()
            editor.apply()
        }

    }
}