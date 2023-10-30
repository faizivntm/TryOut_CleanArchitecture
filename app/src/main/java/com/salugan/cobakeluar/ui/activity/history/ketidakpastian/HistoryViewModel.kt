package com.salugan.cobakeluar.ui.activity.history.ketidakpastian

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.domain.usecases.TryOutUseCase
import com.salugan.cobakeluar.core.domain.usecases.UserUseCase
import com.salugan.cobakeluar.core.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val tryOutUseCase: TryOutUseCase,
    private val userUseCase: UserUseCase
) : ViewModel() {
    fun dataProfile(id: String): LiveData<Result<UserModel>> {
        return userUseCase.getUser(id)
    }

    fun getHasilHistory(id: String): LiveData<Result<List<HasilModel>>> {
        return tryOutUseCase.getHasilTryout(id)
    }
}