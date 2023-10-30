package com.salugan.cobakeluar.ui.activity.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.domain.usecases.UserUseCase
import com.salugan.cobakeluar.core.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userUserCase: UserUseCase
) : ViewModel() {
    fun dataProfile(id: String): LiveData<Result<UserModel>> {
        return userUserCase.getUser(id)
    }
}