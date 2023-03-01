package com.puj.testtaskonlineshop.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity(), AuthFragmentContainer {

    private val binding by lazy {
        ActivityAuthBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun startNewFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fc_auth_fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun startMainMenuActivity() {
        val intent = MainMenuActivity.newIntent(this)
        startActivity(intent)
    }

}