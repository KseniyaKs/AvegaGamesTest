package com.example.avegagamestest.data.network

import com.example.avegagamestest.data.response.event.EventDetailsResponse
import com.example.avegagamestest.data.response.leventslist.EventsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("v1.4/events/")
    suspend fun getEventsList(
        @Query("location") location: String,
        @Query("fields") fields: String = "id,title,images",
        @Query("page") page: Int
    ): Response<EventsListResponse>

    @GET("v1.4/events/{id}/")
    suspend fun getEventDetails(
        @Query("fields") fields: String = "title, description, dates, images",
    ): Response<EventDetailsResponse>
}
