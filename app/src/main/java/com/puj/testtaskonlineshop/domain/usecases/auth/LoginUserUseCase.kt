package com.puj.testtaskonlineshop.domain.usecases.auth

import com.puj.testtaskonlineshop.domain.AuthResult
import com.puj.testtaskonlineshop.domain.UserRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(firstName: String): AuthResult {
        return userRepository.loginUser(firstName)
    }
}