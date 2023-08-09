package com.example.avegagamestest.presentation.model.event

import com.example.avegagamestest.presentation.model.ImageModel

data class EventDetailsModel(
    val dates: List<EventDateModel>,
    val title: String,
    val description: String,
    val fullDescription: String,
    val images: List<ImageModel>
)
