package com.puj.testtaskonlineshop.data

import com.puj.testtaskonlineshop.data.database.dao.UserDao
import com.puj.testtaskonlineshop.data.mappers.UserMapper
import com.puj.testtaskonlineshop.domain.AuthResult
import com.puj.testtaskonlineshop.domain.UserRepository
import com.puj.testtaskonlineshop.domain.models.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userMapper: UserMapper
): UserRepository {

    override suspend fun loginUser(firstName: String): AuthResult {
        val result = userDao.getUserByFirstName(firstName)
        if(result != null){
            return AuthResult.SUCCESS
        }
        return AuthResult.FAILURE
    }

    override suspend fun signInUser(user: User): AuthResult {
        return try {
            val userDbModel = userMapper.mapUserToUserDbModel(user)
            userDao.addUser(userDbModel)
            AuthResult.SUCCESS
        } catch (ex: Exception){
            AuthResult.FAILURE
        }
    }
}