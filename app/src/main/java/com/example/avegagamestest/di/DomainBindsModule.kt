package com.example.avegagamestest.di

import com.example.avegagamestest.data.mapper.ResponseMapperImpl
import com.example.avegagamestest.domain.mapper.ResponseMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsModule {

    @Binds
    @Singleton
    fun provideResponseMapper(impl: ResponseMapperImpl): ResponseMapper
}

