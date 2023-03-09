package com.puj.testtaskonlineshop.data.mappers

import com.puj.testtaskonlineshop.domain.models.User
import com.puj.testtaskonlineshop.data.database.models.UserDbModel
import javax.inject.Inject

class UserMapper @Inject constructor() {

    fun mapUserToUserDbModel(user: User): UserDbModel {
        return UserDbModel(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email
        )
    }
}