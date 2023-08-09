package com.example.avegagamestest.data.response.leventslist

import com.example.avegagamestest.data.response.ImageResponse
import com.google.gson.annotations.SerializedName

data class EventItemResponse(
    @SerializedName("id") val id: Number,
    @SerializedName("title") val title: String,
    @SerializedName("images") val images: List<ImageResponse>
)
