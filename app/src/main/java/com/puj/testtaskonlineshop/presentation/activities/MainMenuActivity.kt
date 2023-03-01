package com.puj.testtaskonlineshop.presentation.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.puj.testtaskonlineshop.databinding.ActivityMainMenuContainerBinding

class MainMenuActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainMenuContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMenuContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, MainMenuActivity::class.java)
        }
    }
}