package com.salugan.cobakeluar.core.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.salugan.cobakeluar.core.data.firebase.FirebaseDataSource
import com.salugan.cobakeluar.core.domain.models.UserModel
import com.salugan.cobakeluar.core.domain.repositories.UserRepository
import com.salugan.cobakeluar.core.utils.DataMapper.toEntity
import com.salugan.cobakeluar.core.utils.DataMapper.toModel
import com.salugan.cobakeluar.core.utils.Result
import com.salugan.cobakeluar.core.utils.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource
) : UserRepository {
    override fun insertUser(user: UserModel): LiveData<Result<String>> {
        return firebaseDataSource.insertUser(user.toEntity())
    }

    override fun getUser(id: String): LiveData<Result<UserModel>> {
        return firebaseDataSource.getUser(id).map { result ->
            result.map { entity ->
                entity.toModel()
            }
        }
    }
}