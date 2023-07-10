package com.muhsanjaved.sharepreferences_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.muhsanjaved.sharepreferences_practice.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor = getPreferences(MODE_PRIVATE)

        binding.editTextText.setText(editor.getString("name",null))

        val isCheck = editor.getBoolean("checkbox",false)
        binding.checkBox.isChecked =isCheck

        binding.buttonSave.setOnClickListener {
            val editor = getPreferences(MODE_PRIVATE).edit()
            editor.putString("name",binding.editTextText.text.toString())
            editor.putBoolean("checkbox", binding.checkBox.isChecked)
            editor.apply()
        }

    }
}