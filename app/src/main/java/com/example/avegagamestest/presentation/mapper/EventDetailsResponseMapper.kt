package com.example.avegagamestest.presentation.mapper

import com.example.avegagamestest.data.response.event.EventDetailsResponse
import com.example.avegagamestest.presentation.model.ImageModel
import com.example.avegagamestest.presentation.model.event.EventDateModel
import com.example.avegagamestest.presentation.model.event.EventDetailsModel
import com.example.avegagamestest.utils.convertLongToDate
import javax.inject.Inject

class EventDetailsResponseMapper @Inject constructor() {

    fun map(response: EventDetailsResponse): EventDetailsModel = EventDetailsModel(
        title = response.title,
        description = response.description,
        fullDescription = response.fullDescription,
        dates = response.dates.map { event ->
            EventDateModel(
                startTime = event.startTime.convertLongToDate(),
            )
        },
        images = response.images.map { event ->
            ImageModel(
                image = event.image
            )
        }
    )
}


