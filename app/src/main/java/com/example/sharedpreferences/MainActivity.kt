package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("note", Context.MODE_PRIVATE)

        binding.notebtn.setOnClickListener {
            val note = binding.noteET.text.toString()
            val editor = sharedPreferences.edit()
            editor.putString("note", note)
            editor.apply()

            Toast.makeText(this, "note add successfully", Toast.LENGTH_SHORT).show()
            binding.noteET.text.clear()
        }
    binding.displaynotebtn.setOnClickListener{
        val note = sharedPreferences.getString("note", null)
        binding.show.text = note
    }



}
}