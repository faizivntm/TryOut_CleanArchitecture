package com.salugan.cobakeluar.ui.activity.authentication.signup

import androidx.lifecycle.ViewModel
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.domain.usecases.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userUseCase: UserUseCase,
) : ViewModel() {
    fun addUser(addData: UserModel) = userUseCase.insertUser(addData)
}