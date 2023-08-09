package com.example.avegagamestest.data.response.leventslist

import com.google.gson.annotations.SerializedName

data class EventsListResponse(
    @SerializedName("next") val nextPage: String?,
    @SerializedName("previous") val previousPage: String?,
    @SerializedName("results") val results: List<EventItemResponse>
)

