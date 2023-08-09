package com.example.avegagamestest.data.response.event

import com.example.avegagamestest.data.response.ImageResponse
import com.google.gson.annotations.SerializedName

data class EventDetailsResponse(
    @SerializedName("dates") val dates: List<EventDateResponse>,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("body_text") val fullDescription: String,
    @SerializedName("images") val images: List<ImageResponse>
)