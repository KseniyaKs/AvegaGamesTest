package com.example.avegagamestest.domain.repository

import androidx.paging.PagingSource
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel

interface EventsListRepository {

    fun getEventsList(location: String): PagingSource<Int, EventItemModel>
}