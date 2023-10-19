package com.salugan.cobakeluar.core.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.salugan.cobakeluar.core.data.api.ApiDataSource
import com.salugan.cobakeluar.core.data.firebase.FirebaseDataSource
import com.salugan.cobakeluar.core.data.local.LocalDataSource
import com.salugan.cobakeluar.core.domain.models.HasilModel
import com.salugan.cobakeluar.core.domain.models.QuestionModel
import com.salugan.cobakeluar.core.domain.repositories.TryoutRepository
import com.salugan.cobakeluar.core.utils.DataMapper.toEntity
import com.salugan.cobakeluar.core.utils.DataMapper.toModel
import com.salugan.cobakeluar.core.utils.Result
import com.salugan.cobakeluar.core.utils.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TryoutRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource,
    private val firebaseDataSource: FirebaseDataSource,
    private val localDataSource: LocalDataSource
) : TryoutRepository {
    override fun insertHasilTryout(data: HasilModel): LiveData<Result<String>> {
        return firebaseDataSource.hasilTryOut(data.toEntity())
    }

    override fun getHasilTryout(id: String): LiveData<Result<List<HasilModel>>> {
        return firebaseDataSource.getHasilTryout(id).map { result ->
            result.map { list ->
                list.map { entity ->
                    entity.toModel()
                }
            }
        }
    }

    override fun getDataDanKetidakPastianQuestions(): LiveData<Result<List<QuestionModel>>> {
        return apiDataSource.getDataDanKetidakPastianQuestions().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }
    }

    override fun getGeometriDanPengukuranQuestion(): LiveData<Result<List<QuestionModel>>> {
        return apiDataSource.getGeometriDanPengukuranQuestion().map { result ->
            result.map { list ->
                list.map { response ->
                    response.toModel()
                }
            }
        }
    }

    override fun getTryoutStatus(): LiveData<Boolean> {
        return localDataSource.getTryoutStatus()
    }

    override suspend fun setTryoutStatus(isFinished: Boolean) {
        localDataSource.setTryoutStatus(isFinished)
    }
}