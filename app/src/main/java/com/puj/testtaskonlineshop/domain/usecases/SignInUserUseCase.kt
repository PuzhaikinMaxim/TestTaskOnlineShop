package com.puj.testtaskonlineshop.domain.usecases

import com.puj.testtaskonlineshop.domain.AuthResult
import com.puj.testtaskonlineshop.domain.UserRepository
import com.puj.testtaskonlineshop.domain.models.User
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(user: User): AuthResult {
        return userRepository.signInUser(user)
    }
}