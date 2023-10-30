package com.salugan.cobakeluar.core.domain.interactors

import androidx.lifecycle.LiveData
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.domain.repositories.UserRepository
import com.salugan.cobakeluar.core.domain.usecases.UserUseCase
import com.salugan.cobakeluar.core.utils.Result
import javax.inject.Inject

class UserInteractor @Inject constructor(private val userRepository: UserRepository):
    UserUseCase {
    override fun insertUser(user: UserModel): LiveData<Result<String>> = userRepository.insertUser(user)
    override fun getUser(id: String): LiveData<Result<UserModel>> = userRepository.getUser(id)
}