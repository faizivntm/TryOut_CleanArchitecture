package com.salugan.cobakeluar.core.domain.repositories

import androidx.lifecycle.LiveData
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.utils.Result

interface UserRepository {
    fun insertUser(user: UserModel): LiveData<Result<String>>
    fun getUser(id: String): LiveData<Result<UserModel>>
}