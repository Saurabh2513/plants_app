package com.example.shopy.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.shopy.MainActivity
import com.example.shopy.databinding.ActivityCreatAccountBinding

class CreateAccount : AppCompatActivity() {
    private lateinit var binding: ActivityCreatAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreatAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signinbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}