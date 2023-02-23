package com.puj.testtaskonlineshop.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}