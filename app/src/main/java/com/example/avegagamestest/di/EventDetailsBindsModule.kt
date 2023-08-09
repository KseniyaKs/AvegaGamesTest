package com.example.avegagamestest.di

import com.example.avegagamestest.data.repository.event.EventRepositoryImpl
import com.example.avegagamestest.domain.repository.EventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface EventDetailsBindsModule {

    @Binds
    @Singleton
    fun provideEventRepository(impl: EventRepositoryImpl): EventRepository
}



