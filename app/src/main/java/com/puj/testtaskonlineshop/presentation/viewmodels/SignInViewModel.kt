package com.puj.testtaskonlineshop.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puj.testtaskonlineshop.domain.AuthResult
import com.puj.testtaskonlineshop.domain.models.User
import com.puj.testtaskonlineshop.domain.usecases.SignInUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInViewModel @Inject constructor(
    private val signInUserUseCase: SignInUserUseCase
): ViewModel() {

    private var _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private var _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail

    private var _errorFieldsNotFilled = MutableLiveData<Unit>()
    val errorFieldsNotFilled: LiveData<Unit>
        get() = _errorFieldsNotFilled

    private var _userAlreadyExistsError = MutableLiveData<Unit>()
    val userAlreadyExistsError: LiveData<Unit>
        get() = _userAlreadyExistsError

    fun signInUser(
        inputFirstName: String?,
        inputLastName: String?,
        inputEmail: String?
    ) {
        val firstName = parseStringField(inputFirstName)
        val lastName = parseStringField(inputLastName)
        val email = parseStringField(inputEmail)

        val isFieldsValid = validateInput(firstName, lastName, email)
        if(isFieldsValid){
            viewModelScope.launch(Dispatchers.Default) {
                val user = User(firstName, lastName, email)

                val result = signInUserUseCase.invoke(user)

                if(result == AuthResult.SUCCESS){
                    closeScreen()
                }
                else{
                    _userAlreadyExistsError.postValue(Unit)
                }
            }
        }
    }

    private fun parseStringField(field: String?): String {
        return field ?: ""
    }

    private fun validateInput(
        firstName: String,
        lastName: String,
        email: String
    ): Boolean {
        if(firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
            _errorFieldsNotFilled.value = Unit
            return false
        }

        val isEmailValid = validateEmail(email)
        if(!isEmailValid) {
            _errorInputEmail.value = true
            return false
        }

        return true
    }

    private fun validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun closeScreen() {
        _shouldCloseScreen.postValue(Unit)
    }
}