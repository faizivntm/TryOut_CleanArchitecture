package com.salugan.cobakeluar.ui.activity.hasil

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salugan.cobakeluar.core.data.local.LocalDataSource
import com.salugan.cobakeluar.core.data.local.TryoutManager
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.usecases.TryOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HasilViewModel @Inject constructor(
    private val tryOutUseCase: TryOutUseCase,
) : ViewModel() {
    fun addHasil(addHasil: HasilModel) = tryOutUseCase.insertHasilTryout(addHasil)
    fun getTryoutStatus(): LiveData<Boolean> = tryOutUseCase.getTryoutStatus()
    fun setTryoutStatus(finished: Boolean) {
        viewModelScope.launch {
            tryOutUseCase.setTryoutStatus(finished)
        }
    }
}