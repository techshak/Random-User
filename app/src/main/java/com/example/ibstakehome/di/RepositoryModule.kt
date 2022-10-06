package com.example.ibstakehome.di

import com.example.ibstakehome.network.UserApi
import com.example.ibstakehome.repositories.UserRepository
import com.example.ibstakehome.repositories.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(
        api: UserApi,
    ): UserRepository {
        return UserRepositoryImpl(api)
    }
}