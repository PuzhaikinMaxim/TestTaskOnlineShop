package com.puj.testtaskonlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.FragmentSignInBinding
import com.puj.testtaskonlineshop.presentation.TestTaskOnlineShopApplication
import com.puj.testtaskonlineshop.presentation.ViewModelFactory
import com.puj.testtaskonlineshop.presentation.activities.AuthFragmentContainer
import com.puj.testtaskonlineshop.presentation.viewmodels.SignInViewModel
import javax.inject.Inject

class SignInFragment: Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding: FragmentSignInBinding
        get() = _binding ?: throw RuntimeException("Sign up binding not set")

    private lateinit var authFragmentContainer: AuthFragmentContainer
    private lateinit var viewModel: SignInViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as TestTaskOnlineShopApplication).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

        if(context is AuthFragmentContainer){
            authFragmentContainer = context
        }
        else{
            throw RuntimeException("Context does not implement AuthFragmentContainer interface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[SignInViewModel::class.java]
        setupOnLogInTextViewClicked()
        setupOnSignInButtonClicked()
        setupEmailErrorTextAppear()
        setupOnShouldCloseScreen()
        setupOnUserAlreadyExistsErrorToast()
        setupFieldsNotFilledErrorToast()
    }

    private fun setupOnLogInTextViewClicked() {
        binding.tvGoToLogInPage.setOnClickListener {
            openLoginFragment()
        }
    }

    private fun setupOnSignInButtonClicked() {
        with(binding){
            btnSignIn.setOnClickListener {
                val inputFirstName = etFirstName.text?.toString()
                val inputLastName = etLastName.text?.toString()
                val inputEmail = etEmail.text?.toString()

                viewModel.signInUser(
                    inputFirstName,
                    inputLastName,
                    inputEmail
                )
            }
        }
    }

    private fun setupOnShouldCloseScreen() {
        viewModel.shouldCloseScreen.observe(requireActivity()){
            openLoginFragment()
        }
    }

    private fun setupOnUserAlreadyExistsErrorToast() {
        viewModel.userAlreadyExistsError.observe(requireActivity()){
            Toast.makeText(
                requireActivity(),
                R.string.user_already_exists_error_toast_text,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupFieldsNotFilledErrorToast() {
        viewModel.errorFieldsNotFilled.observe(requireActivity()){
            Toast.makeText(
                requireActivity(),
                R.string.fields_not_filled_error_toast_text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupEmailErrorTextAppear() {
        viewModel.errorInputEmail.observe(requireActivity()){
            if(it){
                binding.tvEmailError.visibility = View.VISIBLE
            }
        }
        addEmailErrorTextReset()
    }

    private fun addEmailErrorTextReset() {
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvEmailError.visibility = View.GONE
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    private fun openLoginFragment() {
        val fragment = LoginFragment.newFragment()
        authFragmentContainer.startNewFragment(fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}