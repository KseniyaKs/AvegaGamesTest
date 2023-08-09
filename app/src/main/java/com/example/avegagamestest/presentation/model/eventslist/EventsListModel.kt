package com.example.avegagamestest.presentation.model.eventslist

data class EventsListModel(
    val nextPage: String?,
    val previousPage: String?,
    val results: List<EventItemModel>
)
