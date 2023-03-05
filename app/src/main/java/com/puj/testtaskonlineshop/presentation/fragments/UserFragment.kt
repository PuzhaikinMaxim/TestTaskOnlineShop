package com.puj.testtaskonlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.puj.testtaskonlineshop.databinding.FragmentUserBinding
import com.puj.testtaskonlineshop.presentation.activities.MainMenuFragmentContainer

class UserFragment: Fragment() {

    private var _binding: FragmentUserBinding? = null
    private val binding: FragmentUserBinding
        get() = _binding ?: throw RuntimeException("User binding not set")

    private lateinit var mainMenuFragmentContainer: MainMenuFragmentContainer

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is MainMenuFragmentContainer){
            mainMenuFragmentContainer = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserBinding.inflate(inflater,container,false)
        setupOnLogoutButtonClick()
        return binding.root
    }

    private fun setupOnLogoutButtonClick() {
        binding.btnLogout.setOnClickListener {
            mainMenuFragmentContainer.startAuthActivity()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}