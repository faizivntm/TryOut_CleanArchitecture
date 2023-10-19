package com.salugan.cobakeluar.core.di

import com.salugan.cobakeluar.core.data.repositories.TryoutRepositoryImpl
import com.salugan.cobakeluar.core.data.repositories.UserRepositoryImpl
import com.salugan.cobakeluar.core.domain.repositories.TryoutRepository
import com.salugan.cobakeluar.core.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [ApiModule::class, DatabaseModule::class, FirebaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideUserRepository(repository: UserRepositoryImpl): UserRepository

    @Binds
    abstract fun provideTryoutRepository(repository: TryoutRepositoryImpl): TryoutRepository
}