package com.salugan.cobakeluar.core.di

import android.content.Context
import com.salugan.cobakeluar.core.data.local.TryoutManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideTryoutManager(@ApplicationContext context: Context): TryoutManager =
        TryoutManager(context)
}