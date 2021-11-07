package com.example.boredapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.boredapi.databinding.ActivityTermsBinding

class ActivityTerms : AppCompatActivity() {

    private lateinit var binding: ActivityTermsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTermsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClosePageTerm.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }
}