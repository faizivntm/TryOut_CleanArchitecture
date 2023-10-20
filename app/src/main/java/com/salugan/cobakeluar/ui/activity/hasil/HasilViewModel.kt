package com.salugan.cobakeluar.ui.activity.hasil

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.salugan.cobakeluar.core.data.local.TryoutManager
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.data.firebase.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HasilViewModel @Inject constructor(
    private val repository: Repository,
    private val tryoutManager: TryoutManager
) : ViewModel() {
    val resultHasilTO = repository.resulHasilTO
    fun addHasil(addHasil: HasilModel) = repository.hasilTryOut(addHasil)

    // ini ganti ambil ke repository (semua yg pake tryoutmanager)
    fun getTryoutStatus(): LiveData<Boolean> = tryoutManager.tryoutFinished.asLiveData()

    fun setTryoutStatus(finished: Boolean) {
        viewModelScope.launch {
            tryoutManager.setTryoutFinished(finished)
        }
    }
}