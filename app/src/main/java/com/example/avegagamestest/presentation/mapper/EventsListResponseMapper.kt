package com.example.avegagamestest.presentation.mapper

import com.example.avegagamestest.data.response.leventslist.EventsListResponse
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel
import com.example.avegagamestest.presentation.model.eventslist.EventsListModel
import com.example.avegagamestest.utils.titleCaseFirstChar
import javax.inject.Inject

class EventsListResponseMapper @Inject constructor() {

    fun map(response: EventsListResponse): EventsListModel = EventsListModel(
        nextPage = response.nextPage,
        previousPage = response.previousPage,
        results = response.results.map { event ->
            EventItemModel(
                id = event.id,
                title = event.title.titleCaseFirstChar(),
                image = event.images.firstOrNull()?.image
            )
        }
    )
}