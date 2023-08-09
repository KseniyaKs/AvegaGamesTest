package com.example.avegagamestest.presentation.eventslist

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.avegagamestest.domain.repository.EventsListRepository
import com.example.avegagamestest.presentation.model.eventslist.EventItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class EventsListViewModel @Inject constructor(
    private val repository: EventsListRepository,
) : ViewModel() {

    fun newPager(location: String): Flow<PagingData<EventItemModel>> {
        val pager = Pager(PagingConfig(20, enablePlaceholders = false), null) {
            repository.getEventsList(location)
        }
        return pager.flow
    }
}