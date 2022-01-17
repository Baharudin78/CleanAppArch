package com.baharudin.cleanapparch.data.common.module

import android.content.Context
import com.baharudin.cleanapparch.infrastructure.utils.SharedPrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SharedPrefModul {
    @Provides
    fun provideSharedPref(@ApplicationContext context : Context) :SharedPrefs {
        return SharedPrefs(context)
    }
}