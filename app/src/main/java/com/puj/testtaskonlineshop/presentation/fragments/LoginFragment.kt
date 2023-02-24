package com.puj.testtaskonlineshop.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.puj.testtaskonlineshop.R
import com.puj.testtaskonlineshop.databinding.FragmentLoginBinding
import com.puj.testtaskonlineshop.databinding.FragmentSignInBinding
import com.puj.testtaskonlineshop.presentation.TestTaskOnlineShopApplication
import com.puj.testtaskonlineshop.presentation.ViewModelFactory
import com.puj.testtaskonlineshop.presentation.activities.AuthFragmentContainer
import com.puj.testtaskonlineshop.presentation.viewmodels.LoginViewModel
import com.puj.testtaskonlineshop.presentation.viewmodels.SignInViewModel
import javax.inject.Inject

class LoginFragment: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding
        get() = _binding ?: throw RuntimeException("Sign in binding not set")

    private lateinit var authFragmentContainer: AuthFragmentContainer
    private lateinit var viewModel: LoginViewModel

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
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,viewModelFactory)[LoginViewModel::class.java]
        setupOnLoginButtonClicked()
        setupOnFieldsNotFilledErrorToast()
        setupOnUserNotFoundError()
        setupOnShouldCloseScreen()
        setupShowPasswordCheckbox()
    }

    private fun setupShowPasswordCheckbox() {
        binding.cbShowPassword.setOnCheckedChangeListener {
                _, isChecked ->
            run {
                if (isChecked) {
                    binding.etPassword.transformationMethod = null
                } else {
                    binding.etPassword.transformationMethod = PasswordTransformationMethod()
                }
            }
        }
    }

    private fun setupOnLoginButtonClicked() {
        with(binding){
            btnLogin.setOnClickListener {
                val firstName = etFirstName.text?.toString()
                viewModel.loginUser(firstName)
            }
        }
    }

    private fun setupOnUserNotFoundError() {
        viewModel.userNotFoundError.observe(requireActivity()){
            Toast.makeText(
                requireActivity(),
                R.string.user_not_found_error_toast_text,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupOnFieldsNotFilledErrorToast() {
        viewModel.errorFieldsNotFilled.observe(requireActivity()){
            Toast.makeText(
                requireActivity(),
                R.string.fields_not_filled_error_toast_text,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setupOnShouldCloseScreen() {
        viewModel.shouldCloseScreen.observe(requireActivity()){
            Toast.makeText(
                requireActivity(),
                "User has entered",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newFragment(): LoginFragment {
            return LoginFragment()
        }
    }
}