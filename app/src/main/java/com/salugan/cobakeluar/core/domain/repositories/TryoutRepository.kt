package com.salugan.cobakeluar.core.domain.repositories

import androidx.lifecycle.LiveData
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.models.QuestionModel
import com.salugan.cobakeluar.core.utils.Result

interface TryoutRepository {
    fun insertHasilTryout(data: HasilModel): LiveData<Result<String>>
    fun getHasilTryout(id: String): LiveData<Result<List<HasilModel>>>
    fun getDataDanKetidakPastianQuestions(): LiveData<Result<List<QuestionModel>>>
    fun getGeometriDanPengukuranQuestion(): LiveData<Result<List<QuestionModel>>>
    fun getTryoutStatus(): LiveData<Boolean>
    suspend fun setTryoutStatus(isFinished: Boolean)
}