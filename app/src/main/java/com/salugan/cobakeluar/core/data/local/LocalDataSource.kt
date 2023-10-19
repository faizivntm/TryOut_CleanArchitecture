package com.salugan.cobakeluar.core.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val manager: TryoutManager
) {
    fun getTryoutStatus(): LiveData<Boolean> = manager.tryoutFinished.asLiveData()

    suspend fun setTryoutStatus(isFinished: Boolean) = manager.setTryoutFinished(isFinished)
}