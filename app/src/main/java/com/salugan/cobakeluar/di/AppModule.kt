package com.salugan.cobakeluar.di

import com.salugan.cobakeluar.core.domain.interactors.TryOutInteractor
import com.salugan.cobakeluar.core.domain.interactors.UserInteractor
import com.salugan.cobakeluar.core.domain.usecases.TryOutUseCase
import com.salugan.cobakeluar.core.domain.usecases.UserUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideUserUseCase(userInteractor: UserInteractor): UserUseCase
    @Binds
    @ViewModelScoped
    abstract fun provideTryOutUseCase(tryOutInteractor: TryOutInteractor): TryOutUseCase
}
