package com.example.avegagamestest.data.repository.event

import com.example.avegagamestest.data.network.Api
import com.example.avegagamestest.data.response.event.EventDetailsResponse
import com.example.avegagamestest.domain.mapper.ResponseMapper
import com.example.avegagamestest.domain.repository.EventRepository
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val api: Api,
    private val responseMapper: ResponseMapper,
) : EventRepository {

    override suspend fun getEventDetails(id: String): EventDetailsResponse {
        return responseMapper.map(api.getEventDetails(id))
    }
}