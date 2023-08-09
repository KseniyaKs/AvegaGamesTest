package com.example.avegagamestest.data.response.event

import com.google.gson.annotations.SerializedName

data class EventDateResponse(
    @SerializedName("start") val startTime: Long
)
