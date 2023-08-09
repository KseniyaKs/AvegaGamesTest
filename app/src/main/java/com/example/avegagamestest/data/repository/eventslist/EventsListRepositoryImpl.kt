package com.example.avegagamestest.data.repository.eventslist

import androidx.paging.PagingSource
import com.example.avegagamestest.domain.repository.EventsListRepository
import com.example.avegagamestest.presentation.eventslist.GetEventsPagingSource
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel
import javax.inject.Inject

class EventsListRepositoryImpl @Inject constructor(
    private val getEventsPagingSource: GetEventsPagingSource.Factory
) : EventsListRepository {

    override fun getEventsList(location: String): PagingSource<Int, EventItemModel> =
        getEventsPagingSource.create(location)
}