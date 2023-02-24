package com.puj.testtaskonlineshop.domain

import com.puj.testtaskonlineshop.domain.models.User

interface UserRepository {

    suspend fun loginUser(firstName: String): AuthResult

    suspend fun signInUser(user: User): AuthResult
}