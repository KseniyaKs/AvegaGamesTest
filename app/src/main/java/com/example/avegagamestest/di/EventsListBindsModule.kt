package com.example.avegagamestest.di

import com.example.avegagamestest.data.repository.eventslist.EventsListRepositoryImpl
import com.example.avegagamestest.domain.repository.EventsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface EventsListBindsModule {

    @Binds
    @Singleton
    fun provideEventsListRepository(impl: EventsListRepositoryImpl): EventsListRepository
}

