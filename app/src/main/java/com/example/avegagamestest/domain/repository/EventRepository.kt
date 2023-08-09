package com.example.avegagamestest.domain.repository

import com.example.avegagamestest.data.response.event.EventDetailsResponse

interface EventRepository {

    suspend fun getEventDetails(id: String): EventDetailsResponse
}