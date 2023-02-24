package com.puj.testtaskonlineshop.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.puj.testtaskonlineshop.domain.AuthResult
import com.puj.testtaskonlineshop.domain.usecases.LoginUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUserUseCase: LoginUserUseCase
): ViewModel() {

    private var _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    private var _userNotFoundError = MutableLiveData<Unit>()
    val userNotFoundError: LiveData<Unit>
        get() = _userNotFoundError

    private var _errorFieldsNotFilled = MutableLiveData<Unit>()
    val errorFieldsNotFilled: LiveData<Unit>
        get() = _errorFieldsNotFilled

    fun loginUser(
        inputFirstName: String?
    ) {
        val firstName = parseStringField(inputFirstName)

        val isFieldValid = validateInput(firstName)
        if(isFieldValid){
            viewModelScope.launch(Dispatchers.Default) {
                val result = loginUserUseCase.invoke(firstName)
                if(result == AuthResult.SUCCESS){
                    _shouldCloseScreen.postValue(Unit)
                }
                else{
                    _userNotFoundError.postValue(Unit)
                }
            }
        }
    }

    private fun parseStringField(field: String?): String {
        return field ?: ""
    }

    private fun validateInput(
        firstName: String
    ): Boolean {
        if(firstName.isBlank()) {
            _errorFieldsNotFilled.value = Unit
            return false
        }

        return true
    }
}