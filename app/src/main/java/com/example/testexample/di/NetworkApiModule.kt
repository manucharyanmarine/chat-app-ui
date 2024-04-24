package com.example.testexample.di

import com.example.testexample.service.ChatApi
import com.example.testexample.service.NetworkCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkApiModule {
    @Provides
    @Singleton
    fun provideChatApi(
        networkCreator: NetworkCreator
    ): ChatApi = networkCreator.provideChatApi()
}