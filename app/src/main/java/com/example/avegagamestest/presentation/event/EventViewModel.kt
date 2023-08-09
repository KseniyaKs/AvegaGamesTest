package com.example.avegagamestest.presentation.event

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.avegagamestest.domain.repository.EventRepository
import com.example.avegagamestest.presentation.mapper.EventDetailsResponseMapper
import com.example.avegagamestest.presentation.model.event.EventDetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val repository: EventRepository,
    private val mapper: EventDetailsResponseMapper
) : ViewModel() {

    val eventDetails: MutableLiveData<EventDetailsModel?> by lazy {
        MutableLiveData<EventDetailsModel?>()
    }

    fun getEventDetail(id: String) {
        viewModelScope.launch {
            val eventModel = mapper.map(repository.getEventDetails(id))
            eventDetails.value = eventModel
        }
    }
}