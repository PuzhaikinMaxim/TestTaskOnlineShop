package com.puj.testtaskonlineshop.presentation.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.ActivityMainMenuContainerBinding

class MainMenuActivity: AppCompatActivity(), MainMenuFragmentContainer {

    private lateinit var binding: ActivityMainMenuContainerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainMenuContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomMenu()
    }

    private fun setupBottomMenu() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fc_main)
                as NavHostFragment

        binding.bnvBottom.setupWithNavController(navHostFragment.navController)
    }

    override fun startAuthActivity() {
        val intent = AuthActivity.newIntent(this)
        startActivity(intent)
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, MainMenuActivity::class.java)
        }
    }


}