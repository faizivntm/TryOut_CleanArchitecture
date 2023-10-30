package com.salugan.cobakeluar.core.domain.interactors

import androidx.lifecycle.LiveData
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.models.QuestionModel
import com.salugan.cobakeluar.core.domain.repositories.TryoutRepository
import com.salugan.cobakeluar.core.domain.usecases.TryOutUseCase
import com.salugan.cobakeluar.core.utils.Result
import javax.inject.Inject

class TryOutInteractor @Inject constructor(private val tryoutRepository: TryoutRepository):
    TryOutUseCase{
    override fun insertHasilTryout(data: HasilModel): LiveData<Result<String>> = tryoutRepository.insertHasilTryout(data)
    override fun getHasilTryout(id: String): LiveData<Result<List<HasilModel>>> = tryoutRepository.getHasilTryout(id)
    override fun getDataDanKetidakPastianQuestions(): LiveData<Result<List<QuestionModel>>> = tryoutRepository.getDataDanKetidakPastianQuestions()
    override fun getGeometriDanPengukuranQuestion(): LiveData<Result<List<QuestionModel>>> = tryoutRepository.getGeometriDanPengukuranQuestion()
    override fun getTryoutStatus(): LiveData<Boolean> = tryoutRepository.getTryoutStatus()
    override suspend fun setTryoutStatus(isFinished: Boolean) = tryoutRepository.setTryoutStatus(isFinished = true)
}